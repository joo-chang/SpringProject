package hello.core;

import jdk.jfr.Enabled;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {

    @Test
    @EnabledOnOs({OS.MAC, OS.LINUX})
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_11})
    @DisplayName("스터디 fast")
    @FastTest
    void create() {
        System.out.println("create");
        Study study = new Study(10);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Study(-10));

        String message = exception.getMessage();
        assertEquals(message, "Limit은 0보다 커야 한다.");

        // assertTimeoutPreemptively -> 지정한 시간이 지나면 바로 종료
//        assertTimeout(Duration.ofMillis(100), () -> {
//            new Study(10);
//            Thread.sleep(300);
//        });
        // 각각 실행하면 여러 개 오류가 나야 하는 코드여도 하나 오류만 뱉는데
        // assertAll로 묶으면 여러 개 오류 다 같이 출력한다.
        assertAll(
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "스터디를 처음 만들면 상태값이 "+ StudyStatus.DRAFT +"여야한다."),
                () -> assertNotNull(study),
                () -> assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야된다.")
        );

    }
    @Test
    @Tag("slow")
    void create2() {
        System.out.println("create2");
        Study study = new Study(10);
        assertNotNull(study);
    }

    @DisplayName("스터디 만들기")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void repeatTest(RepetitionInfo repetitionInfo) {
        System.out.println("repetitionInfo = " + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());
    }

    @ParameterizedTest
    @ValueSource(strings = {"날씨가", "많이", "추워지고", "있네요"})
    void paramTest(String msg) {
        System.out.println(msg);
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("StudyTest.beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("StudyTest.afterAll");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("StudyTest.beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("StudyTest.afterEach");
        System.out.println();
    }

}