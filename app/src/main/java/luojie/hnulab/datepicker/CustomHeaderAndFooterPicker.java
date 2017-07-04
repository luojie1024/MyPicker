package luojie.hnulab.datepicker;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import luojie.hnulab.librarydemo.picker.DatePicker;


/**
 * description:自定义头尾标签选择器
 * auther：joahluo
 * time：2017/7/1 16:39
 */
public class CustomHeaderAndFooterPicker extends DatePicker implements DatePicker.OnWheelListener {


    public CustomHeaderAndFooterPicker(Activity activity) {
        super(activity);
    }




    public CustomHeaderAndFooterPicker(Activity activity, @DateMode int mode) {
        super(activity, mode);
        //设置label颜色（灰）  选中颜色 （黑） 未选中颜色（灰）
        setLabelTextColor(0xFF999999,0xFF333333,0xFF999999);
        //设置边线颜色（灰）
        setDividerColor(0xFF999999);
        //关闭顶部栏
        setTopLineVisible(false);
    }

    @Nullable
    @Override
    protected View makeHeaderView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.picker_header, null);
        return view;
    }

    @Nullable
    @Override
    protected View makeFooterView() {
        View view = LayoutInflater.from(activity).inflate(R.layout.picker_footer, null);
        Button submitView = (Button) view.findViewById(R.id.picker_submit);
        submitView.setText(submitText);
        submitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                onSubmit();
            }
        });
        return view;
    }


    @Override
    public void onSubmit() {
        super.onSubmit();
    }


    @Override
    public void onYearWheeled(int index, String year) {

    }

    @Override
    public void onMonthWheeled(int index, String month) {

    }

    @Override
    public void onDayWheeled(int index, String day) {

    }
}
