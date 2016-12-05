package com.weavey.dialog.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import com.wevey.selector.dialog.DialogInterface;
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
    }

    private void initBottomDialog() {


        final ArrayList<String> s = new ArrayList<>();
        s.add("Weavey0");
        s.add("Weavey1");
        s.add("Weavey2");
        s.add("Weavey3");

        NormalSelectionDialog dialog  = new NormalSelectionDialog.Builder(this)
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
                .setOnItemListener(new DialogInterface.OnItemClickListener<NormalSelectionDialog>() {


                    @Override
                    public void onItemClick(NormalSelectionDialog dialog, View button, int position) {

                        dialog.dismiss();
                    }
                }).setCanceledOnTouchOutside(true)  //设置是否可点击其他地方取消dialog
                .build();

        dialog.setDatas(s);
        dialog.show();


    }

    private void initNormalDialog(){

      new NormalAlertDialog.Builder(MainActivity.this)
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
                .setOnclickListener(new DialogInterface.OnLeftAndRightClickListener<NormalAlertDialog>() {
                    @Override
                    public void clickLeftButton(NormalAlertDialog dialog, View view) {

                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(NormalAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }
                })
                .build().show();

    }

    private void initNormalDialog2(){

        new NormalAlertDialog.Builder(MainActivity.this)
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
                .setSingleListener(new DialogInterface.OnSingleClickListener<NormalAlertDialog>() {
                    @Override
                    public void clickSingleButton(NormalAlertDialog dialog, View view) {

                        dialog.dismiss();
                    }
                })
                .build().show();

    }

    private void initMDDialog() {

      new MDAlertDialog.Builder(MainActivity.this)
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
                .setOnclickListener(new DialogInterface.OnLeftAndRightClickListener<MDAlertDialog>() {

                    @Override
                    public void clickLeftButton(MDAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(MDAlertDialog dialog, View view) {
                        dialog.dismiss();
                    }
                })
                .build().show();

    }

    private void initMDMidDialog(){

       MDSelectionDialog dialog = new MDSelectionDialog.Builder(MainActivity.this)
                .setCanceledOnTouchOutside(true)
                .setItemTextColor(R.color.black_light)
                .setItemHeight(50)
                .setItemWidth(0.8f)  //屏幕宽度*0.8
                .setItemTextSize(15)
                .setCanceledOnTouchOutside(true)
                .setOnItemListener(new DialogInterface.OnItemClickListener<MDSelectionDialog>() {
                    @Override
                    public void onItemClick(MDSelectionDialog dialog, View button, int position) {

                        dialog.dismiss();
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
        dialog.setDatas(datas);
        dialog.show();
    }

    private void initMDEditDialog(){

         new MDEditDialog.Builder(MainActivity.this)
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
                 .setInputTpye(InputType.TYPE_CLASS_NUMBER)
                .setOnclickListener(new DialogInterface.OnClickEditDialogListener() {
                    @Override
                    public void clickLeftButton(MDEditDialog dialog, View view, String editText) {
                        dialog.dismiss();
                    }

                    @Override
                    public void clickRightButton(MDEditDialog dialog, View view, String editText) {

                        dialog.dismiss();
                    }
                })
                .setMinHeight(0.3f)
                .setWidth(0.8f)
                .build().show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.button1 :

                initBottomDialog();
                break;

            case R.id.button2 :

                initNormalDialog();
                break;

            case R.id.button3 :

                initNormalDialog2();
                break;

            case R.id.button4 :

                initMDDialog();
                break;

            case R.id.button5 :

                initMDMidDialog();
                break;

            case R.id.button6 :

                initMDEditDialog();
                break;
        }

    }
}
