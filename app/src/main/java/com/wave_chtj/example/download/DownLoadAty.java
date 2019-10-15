package com.wave_chtj.example.download;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.chtj.base_iotutils.ToastUtils;
import com.chtj.base_iotutils.download.DownLoadManager;
import com.chtj.base_iotutils.download.progress.ProgressCallBack;
import com.wave_chtj.example.R;
import com.wave_chtj.example.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

/**
 * Create on 2019/10/10
 * author chtj
 */
public class DownLoadAty extends BaseActivity {
    public static final String TAG = "DownLoadAty";
    //文件下载地址
    public String downloadUrl = "https://fireware-1257276602.cos.ap-guangzhou.myqcloud.com/20190905/Cloud.apk";
    //存放地址
    public String destFileDir = Environment.getExternalStorageDirectory().getAbsolutePath();
    //文件名称
    public String destFileName = "Cloud.apk";
    @BindView(R.id.pb_progressbar)
    ProgressBar pbProgressbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        ButterKnife.bind(this);
    }

    //文件下载
    public void downloadFile(View view) {
        DownLoadManager.getInstance().load(downloadUrl, new ProgressCallBack<ResponseBody>(destFileDir, destFileName) {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                ToastUtils.showShort("文件下载完成！");
            }

            @Override
            public void progress(final long progress, final long total) {
                Log.e(TAG, "progress=" + progress + ",total=" + total);
                double progressNumber = ((progress * 1.0) / total) * 100;
                Log.e(TAG, "progressNumber=" + progressNumber);
                pbProgressbar.setProgress((int) progressNumber);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                ToastUtils.showShort("文件下载失败！");
            }
        });
    }
}
