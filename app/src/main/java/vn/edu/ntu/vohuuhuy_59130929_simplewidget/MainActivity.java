package vn.edu.ntu.vohuuhuy_59130929_simplewidget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  EditText editTen, editNgaySinh, editSTKhac;
  RadioGroup rdgGioiTinh;
  Button btnXacNhan;
  CheckBox[] chkBoxSoThich;
  Integer[] chkBoxIds = { R.id.chkBoxST1, R.id.chkBoxST2, R.id.chkBoxST3, R.id.chkBoxST4, R.id.chkBoxST5 };
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    addViews();
    addEvents();
  }
  private void addViews () {
    editTen = findViewById(R.id.editTen);
    editNgaySinh = findViewById(R.id.editNgaySinh);
    editSTKhac = findViewById(R.id.editSTKhac);
    rdgGioiTinh = findViewById(R.id.rdgGioiTinh);
    btnXacNhan = findViewById(R.id.btnXacNhan);
    chkBoxSoThich = new CheckBox[chkBoxIds.length];
    for (int i = 0; i < chkBoxIds.length; i++) {
      chkBoxSoThich[i] = (CheckBox) findViewById(chkBoxIds[i]);
    }
  }
  private void addEvents () {
    btnXacNhan.setOnClickListener(new View.OnClickListener() {
      @RequiresApi(api = Build.VERSION_CODES.O)
      @Override
      public void onClick(View v) {
        xacNhan();
      }
    });
  }
  @RequiresApi(api = Build.VERSION_CODES.O)
  private  void xacNhan () {
    String thongBao = "";
    thongBao += String.valueOf(editTen.getText()) + "\n";
    thongBao += "Ngày sinh: " + String.valueOf(editNgaySinh.getText()) + "\n";
    thongBao += "Giới tính: ";
    switch (rdgGioiTinh.getCheckedRadioButtonId()) {
      case R.id.rdGTNam:
        thongBao += "Nam \n";
        break;
      case R.id.rdGTNu:
        thongBao += "Nữ \n";
        break;
      default:
    }
    thongBao += "Sở thích: ";
    List<String> soThichArray =  new ArrayList<String>();
    for (int i = 0; i < chkBoxSoThich.length; i++) {
      if (chkBoxSoThich[i].isChecked()) {
        soThichArray.add((String) chkBoxSoThich[i].getText());
      }
    }
    String soThichKhac = String.valueOf(editSTKhac.getText());
    if (soThichKhac != "") {
      soThichArray.add(soThichKhac);
    }
    thongBao += String.join("; ", soThichArray) + "\n";
    Toast.makeText(getApplicationContext(), thongBao, Toast.LENGTH_LONG).show();
  }
}
