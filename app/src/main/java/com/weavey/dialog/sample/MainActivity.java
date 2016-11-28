package com.weavey.dialog.sample;

import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.wevey.selector.dialog.DialogOnClickListener;
import com.wevey.selector.dialog.DialogOnItemClickListener;
import com.wevey.selector.dialog.MDEditDialog;
import com.wevey.selector.dialog.NormalSelectionDialog;
import com.wevey.selector.dialog.MDSelectionDialog;
import com.wevey.selector.dialog.MDAlertDialog;
import com.wevey.selector.dialog.NormalAlertDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private NormalSelectionDialog dialog1;
    private NormalAlertDialog dialog2;
    private NormalAlertDialog dialog3;
    private MDAlertDialog dialog4;
    private MDSelectionDialog dialog5;
    private MDEditDialog dialog6;
    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);

        initBottomDialog();
        initNormalDialog();
        initNormalDialog2();
        initMDDialog();
        initMDMidDialog();
        initMDEditDialog();

    }

    private void initBottomDialog() {


        final ArrayList<String> s = new ArrayList<>();
        s.add("Weavey0");
        s.add("Weavey1");
        s.add("Weavey2");
        s.add("Weavey3");

        dialog1 = new NormalSelectionDialog.Builder(this)
                .setlTitleVisible(true)   //设置是否显示标题
                .setTitleHeight(65)   //设置标题高度
                .setTitleText("please select")  //设置标题提示文本
                .setTitleTextSize(14) //设置标题字体大小 sp
                .setTitleTextColor(R.color.colorPrimary) //设置标题文本颜色
                .setItemHeight(40)  //设置item的高度
                .setItemWidth(0.9f)  //屏幕宽度*0.9
                .setItemTextColor(R.color.colorPrimaryDark)  //设置item字体颜色
                .setItemTextSize(14)  //设置item字体大小
                .setCancleButtonText("Cancle")  //设置最底部“取消”按钮文本
                .setOnItemListener(new DialogOnItemClickListener() {  //监听item点击事件
                         @Override
                         public void onItemClick(Button button, int position) {

                                dialog1.dismiss();
                                Toast.makeText(MainActivity.this, s.get(position), Toast.LENGTH_SHORT).show();
                         }
                })
                .setCanceledOnTouchOutside(true)  //设置是否可点击其他地方取消dialog
                .build();


        dialog1.setDataList(s);


    }

    private void initNormalDialog(){

      dialog2 = new NormalAlertDialog.Builder(MainActivity.this)
                .setHeight(0.23f)  //屏幕高度*0.23
                .setWidth(0.65f)  //屏幕宽度*0.65
                .setTitleVisible(true)
                .setTitleText("温馨提示")
                .setTitleTextColor(R.color.black_light)
                .setContentText("是否关闭对话框？")
                .setContentTextColor(R.color.black_light)
                .setLeftButtonText("关闭")
                .setLeftButtonTextColor(R.color.gray)
                .setRightButtonText("不关闭")
                .setRightButtonTextColor(R.color.black_light)
                .setOnclickListener(new DialogOnClickListener() {
                    @Override
                    public void clickLeftButton(View view) {
                        dialog2.dismiss();
                    }

                    @Override
                    public void clickRightButton(View view) {

                        dialog2.dismiss();
                    }
                })
                .build();

    }

    private void initNormalDialog2(){

         dialog3 = new NormalAlertDialog.Builder(MainActivity.this)
                .setHeight(0.23f)  //屏幕高度*0.23
                .setWidth(0.65f)  //屏幕宽度*0.65
                .setTitleVisible(true)
                .setTitleText("温馨提示")
                .setTitleTextColor(R.color.colorPrimary)
                .setContentText("是否关闭对话框？")
                .setContentTextColor(R.color.colorPrimaryDark)
                .setSingleMode(true)
                .setSingleButtonText("关闭")
                .setSingleButtonTextColor(R.color.colorAccent)
                .setCanceledOnTouchOutside(true)
                .setSingleListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog3.dismiss();
                    }
                })
                .build();

    }

    private void initMDDialog() {

      dialog4 = new MDAlertDialog.Builder(MainActivity.this)
                .setHeight(0.21f)  //屏幕高度*0.21
                .setWidth(0.7f)  //屏幕宽度*0.7
                .setTitleVisible(true)
                .setTitleText("温馨提示")
                .setTitleTextColor(R.color.black_light)
                .setContentText("确定发送文件？")
                .setContentTextColor(R.color.black_light)
                .setLeftButtonText("不发送")
                .setLeftButtonTextColor(R.color.gray)
                .setRightButtonText("发送")
                .setRightButtonTextColor(R.color.black_light)
                .setTitleTextSize(16)
                .setContentTextSize(14)
                .setButtonTextSize(14)
                .setOnclickListener(new DialogOnClickListener() {
                    @Override
                    public void clickLeftButton(View view) {

                        dialog4.dismiss();
                    }

                    @Override
                    public void clickRightButton(View view) {

                        dialog4.dismiss();
                    }
                })
                .build();

    }

    private void initMDMidDialog(){

         dialog5 = new MDSelectionDialog.Builder(MainActivity.this)
                .setCanceledOnTouchOutside(true)
                .setItemTextColor(R.color.black_light)
                .setItemHeight(50)
                .setItemWidth(0.8f)  //屏幕宽度*0.8
                .setItemTextSize(15)
                .setCanceledOnTouchOutside(true)
                .setOnItemListener(new DialogOnItemClickListener() {
                    @Override
                    public void onItemClick(Button button, int position) {

                        Toast.makeText(MainActivity.this, datas.get(position), Toast.LENGTH_SHORT).show();
                        dialog5.dismiss();
                    }
                })
                .build();

        datas = new ArrayList<>();
        datas.add("标为未读");
        datas.add("置顶聊天");
        datas.add("删除该聊天");
        datas.add("删除该聊天");
        datas.add("删除该聊天");
        datas.add("删除该聊天");
        dialog5.setDataList(datas);
    }

    private void initMDEditDialog(){

         dialog6 = new MDEditDialog.Builder(MainActivity.this)
                .setTitleVisible(true)
                .setTitleText("修改用户名")
                .setTitleTextSize(20)
                .setTitleTextColor(R.color.black_light)
                .setContentText("Weavey")
                .setContentTextSize(18)
                .setMaxLength(7)
                .setHintText("7位字符")
                .setMaxLines(1)
                .setContentTextColor(R.color.colorPrimary)
                .setButtonTextSize(14)
                .setLeftButtonTextColor(R.color.colorPrimary)
                .setLeftButtonText("取消")
                .setRightButtonTextColor(R.color.colorPrimary)
                .setRightButtonText("确定")
                .setLineColor(R.color.colorPrimary)
                .setOnclickListener(new MDEditDialog.OnClickEditDialogListener() {
                    @Override
                    public void clickLeftButton(View view, String text) {

                        //text为编辑的内容
                        dialog6.dismiss();
                    }



                    @Override
                    public void clickRightButton(View view, String text) {

                        //text为编辑的内容
                        dialog6.dismiss();
                    }
                })
                .setMinHeight(0.3f)
                .setWidth(0.8f)
                .build();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button1 :

                dialog1.show();
                break;

            case R.id.button2 :

                dialog2.show();
                break;

            case R.id.button3 :

                dialog3.show();
                break;

            case R.id.button4 :

                dialog4.show();
                break;

            case R.id.button5 :

                dialog5.show();
                break;

            case R.id.button6 :

                dialog6.show();
                break;
        }

    }
}
