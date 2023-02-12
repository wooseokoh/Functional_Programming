package com.example.functional_programming;

import java.io.File;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.example.functional_programming.fileWrite.BookWriter;
import com.example.functional_programming.fileWrite.BookWriterEAM;
import org.junit.jupiter.api.Test;

public class HandleExceptionTest {

    @Test
    public void 람다식에서_예외처리하는법() {
        Stream.of("/usr", "/tmp").map(path -> {
            try {
                return new File(path).getCanonicalPath();
            } catch (IOException e) {
                return e.getMessage();
            }
        }).forEach(System.out::println);
        // try~catch로 감싸주면 끝일수도 있지만
        // 발생된 예외를 전파해야할 때도 있다.
    }

    //ARM: Automatic Resource Management
    // try-with-resource 구문
    @Test
    public void 예상치못한상황으로_close가되지_못할_수_있다() {
        // try-with-resource 구분을 사용하면 자동으로 close된다.
        // (알아서 finally 구문을 만들어준다.)
        // 단, AutoCloseable 인터페이스를 구현해야 한다.
        try (BookWriter writer = new BookWriter("bin/myBook.txt");) {
            writer.writeChapter("chapter-2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // EAM: Eexcute Around Method Pattern
    // 함수 실행시 규칙적으로 일어나는 일을 묶어 놓는 패턴
    // 여기서는 리소스 할당/해제가 EAM이 된다.
    @Test
    public void 람다식으로_리소스_사용을_표현해보자() throws IOException {
        String bookName = "book-eam";
        Consumer<BookWriterEAM> block = (bookWriter) -> {
            try {
                bookWriter.writeChapter("chapter-eam1\n");
                bookWriter.writeChapter("chapter-eam2\n");
                bookWriter.writeChapter("chapter-eam3\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        BookWriterEAM.use( block , bookName);
    }
}