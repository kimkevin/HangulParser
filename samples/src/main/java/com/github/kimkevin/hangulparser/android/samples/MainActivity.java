package com.github.kimkevin.hangulparser.android.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kimkevin.hangulparser.HangulParser;
import com.github.kimkevin.hangulparser.HangulParserException;

import java.util.List;

public class MainActivity extends AppCompatActivity {

  private EditText inputEv;
  private TextView resultTv;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    inputEv = (EditText) findViewById(R.id.input_edit);
    resultTv = (TextView) findViewById(R.id.result_txt);
  }

  public void assemble(View v) {
    try {
      resultTv.setText(strListToString(HangulParser.getInstance().disassemble(inputEv.getText().toString())));
    } catch (HangulParserException e) {
      e.printStackTrace();

      resultTv.setText(e.getMessage());
    }
  }

  public String strListToString(List<String> strList) {
    String newStr = "";
    for (int i = 0, li = strList.size(); i < li; i++) {
      newStr += strList.get(i);

      if (i != strList.size() - 1) newStr += " , ";
    }
    return newStr;
  }
}
