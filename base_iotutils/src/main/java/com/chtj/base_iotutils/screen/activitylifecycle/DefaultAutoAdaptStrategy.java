/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.chtj.base_iotutils.screen.activitylifecycle;

import android.app.Activity;
import android.util.Log;

import com.chtj.base_iotutils.back_service.BaseIotTools;

/**
 * ================================================
 * 屏幕适配逻辑策略默认实现类,
 */
public class DefaultAutoAdaptStrategy implements AutoAdaptStrategy {
    private static final String TAG = DefaultAutoAdaptStrategy.class.getSimpleName();

    @Override
    public void applyAdapt(Object target, Activity activity) {
        //是否开启了适配
        BaseIotTools.autoConvertDensityOfGlobal(activity);
    }
}
