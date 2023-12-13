package ua.com.lvivjavavclub.crac;

import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class StatefulApplicationLifeCycle implements SmartLifecycle {
//    implements Resource(org.crac)
//    @Override
//    public void beforeCheckpoint(Context<? extends Resource> context) throws Exception {
//        System.out.println();
//    }
//
//    @Override
//    public void afterRestore(Context<? extends Resource> context) throws Exception {
//
//    }

    private final AtomicBoolean state = new AtomicBoolean(false);

    @Override
    public void start() {
        if (state.compareAndSet(false,true)) {
            System.out.println("StatefulApplicationLifeCycle => Application started");
        }
    }

    @Override
    public void stop() {
        if (state.compareAndSet(true,false)) {
            System.out.println("StatefulApplicationLifeCycle => Application stopped");
        }
    }

    @Override
    public boolean isRunning() {
        return state.get();
    }
}
