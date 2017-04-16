package hua.com.activityextend;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends PreferenceActivity{

        private String [] single_list = {"Alpha option 01","Beta option 02","Charlie option 03"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        Intent intent;
        switch (preference.getKey()){
            case "Screen_Preference":
                 intent=new Intent(MainActivity.this,ScreenPreferenceActivity.class);
                startActivity(intent);
                break;
            case "Intent_Preference":
                Uri uri = Uri.parse("http://www.baidu.com");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
                break;

            case "alter_list":
                showAlterListDialog();
                break;
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }


    private void showAlterListDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose one");//设置标题
        builder.setSingleChoiceItems(single_list, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                String str = single_list[which];
                Toast.makeText(MainActivity.this, "你选择的是"+str+"！",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();//获取dialog
        dialog.show();//显示对话框
    }
}
