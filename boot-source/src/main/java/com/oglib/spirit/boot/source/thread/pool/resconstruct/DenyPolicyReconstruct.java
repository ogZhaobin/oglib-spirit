package com.oglib.spirit.boot.source.thread.pool.resconstruct;

/**
 * 线程池执行策略
 *     <reject>
 *         <policy>discard</policy>
 *         <description>丢弃</description>
 *         <policy>abort</policy>
 *         <description>抛出异常</description>
 *         <policy>runner</policy>
 *         <description>在当前的线程中运行</description>
 *     </reject>
 * @param <T> 线程
 * @author og 19.11.27
 */
public interface DenyPolicyReconstruct<T> {

    void reject(T runnable, ThreadPoolExecutorReconstruct threadPool);

    /**
     * 线程池丢弃策略
     */
    class DiscardDenyPolicy implements DenyPolicyReconstruct<Runnable> {

        @Override
        public void reject(Runnable runnable, ThreadPoolExecutorReconstruct threadPool) {
            System.out.println(String.format("%s do nothing", runnable));
        }
    }

    /**
     * 线程池异常策略
     */
    class AbortDenyPolicy implements DenyPolicyReconstruct<Runnable> {
        @Override
        public void reject(Runnable runnable, ThreadPoolExecutorReconstruct threadPool) {
            throw new RunnableDenyException(String.format("The runnable %s will be abort", runnable));
        }
    }

    /**
     * 将任务在当前线程中执行
     */
    class RunnerDenyPolicy implements DenyPolicyReconstruct<Runnable> {

        @Override
        public void reject(Runnable runnable, ThreadPoolExecutorReconstruct threadPool) {
            if(!threadPool.isShutdown()){
                runnable.run();
            }
        }
    }

}
