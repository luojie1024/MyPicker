package luojie.hnulab.datepicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import luojie.hnulab.librarydemo.picker.DatePicker;


public class DatePickerActivity extends Activity {
          @Override
          protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_date_picker);
          }



          //初始化标题栏高度
          private int getTitleBarHeight() {
                    //获取标题栏高度
                    int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
                    int statusBarHeight=0;
                    if (resourceId > 0) {
                              //根据资源ID获取响应的尺寸值
                              statusBarHeight = getResources().getDimensionPixelSize(resourceId);
                    }
                    int contentTop = getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
                    //statusBarHeight是上面所求的状态栏的高度
                    int titleBarHeight = contentTop - statusBarHeight;
                    return titleBarHeight;
          }



          public void onYearMonthDayPicker(View view) {
                    luojie.hnulab.datepicker.CustomHeaderAndFooterPicker picker = new luojie.hnulab.datepicker.CustomHeaderAndFooterPicker(this, DatePicker.YEAR_MONTH_DAY);
                    picker.setRangeEnd(2111, 1, 11);
                    picker.setRangeStart(2016, 8, 29);
                    picker.setSelectedItem(2050, 10, 14);

                    picker.setTopPadding(50);

                    //设置滚轮条目数量（上下各2个） 默认是3
                    picker.setOffset(2);
                    //设置滚轮左右间隔
                    picker.setPadding(19);
                    //设置滚轮上下间隔
                    picker.setLineSpaceMultiplier(2.6f);
                    //设置位置在View下
                    picker.setDisplayPosition(findViewById(R.id.yearmonthday),getTitleBarHeight());


                    picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                              @Override
                              public void onDatePicked(String year, String month, String day) {
                                        showToast(year + "-" + month + "-" + day);
                              }
                    });
                    picker.show();
          }

          public void onMonthDayPicker(View view) {
                    luojie.hnulab.datepicker.CustomHeaderAndFooterPicker picker = new luojie.hnulab.datepicker.CustomHeaderAndFooterPicker(this, DatePicker.MONTH_DAY);
                    picker.setSelectedItem(10, 14);
                    picker.setDisplayPosition(findViewById(R.id.monthday),getTitleBarHeight());

                    picker.setOnDatePickListener(new DatePicker.OnMonthDayPickListener() {

                              @Override
                              public void onDatePicked(String month, String day) {
                                        showToast(month + "-" + day);
                              }
                    });
                    picker.show();
          }

          public void onYearMonthPicker(View view) {
                    luojie.hnulab.datepicker.CustomHeaderAndFooterPicker picker = new luojie.hnulab.datepicker.CustomHeaderAndFooterPicker(this, DatePicker.YEAR_MONTH);
                    picker.setRangeEnd(2111, 1);
                    picker.setRangeStart(2016, 8);
                    picker.setSelectedItem(2050, 10);
                    picker.setDisplayPosition(findViewById(R.id.yearmonth),getTitleBarHeight());
                    picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {

                              @Override
                              public void onDatePicked(String year, String month) {
                                        showToast(year + "-" + month);
                              }
                    });
                    picker.show();
          }


          public void onYearPicker(View view) {
                    luojie.hnulab.datepicker.CustomHeaderAndFooterPicker picker = new CustomHeaderAndFooterPicker(this, DatePicker.YEAR);
                    picker.setRangeStart(1999);
                    picker.setRangeEnd(2030);
                    picker.setSelectedItem(2010);
                    picker.setGravity(Gravity.CENTER);
//                    picker.setDisplayPosition(findViewById(R.id.year),getTitleBarHeight());
                    picker.setOnDatePickListener(new DatePicker.OnYearPickListener() {
                              @Override
                              public void onDatePicked(String year) {
                                        showToast(year);
                              }
                    });
                    picker.show();
          }

          private void showToast(String msg) {
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
          }
}
