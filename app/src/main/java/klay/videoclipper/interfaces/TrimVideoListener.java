package klay.videoclipper.interfaces;

/**
 * Author：J.Chou
 * Date：  2016.08.01 2:23 PM
 * Email： who_know_me@163.com
 * Describe:
 */
public interface TrimVideoListener {
    void onStartTrim();
    void onFinishTrim(String url);
    void onCancel();
}
