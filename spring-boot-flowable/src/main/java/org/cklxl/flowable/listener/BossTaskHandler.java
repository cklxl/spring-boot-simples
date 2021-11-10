package org.cklxl.flowable.listener;

import org.flowable.task.service.delegate.DelegateTask;
import org.flowable.task.service.delegate.TaskListener;

/**
 * <p>
 *
 * </p>
 *
 * @author Kun.Chen
 * @date 2021/5/18 13:47
 */
public class BossTaskHandler implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("老板");
    }

}
