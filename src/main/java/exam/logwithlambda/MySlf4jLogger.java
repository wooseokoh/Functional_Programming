package exam.logwithlambda;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class MySlf4jLogger {

    public void debug(String format, Supplier<?> supplier){
        if(log.isDebugEnabled()){
            log.debug(format, supplier.get());
        }
    }

    public void trace(String format, Supplier<?> supplier){
        if(log.isTraceEnabled()){
            log.debug(format, supplier.get());
        }
    }
}
