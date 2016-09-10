package id.sch.smktelkom_mlg.tugas01.xirpl3033.sellanp_tugas01;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNM;
    CheckBox cbVocal, cbDance, cbActing, cbCP;
    RadioButton rbSolo, rbGroup, rbAA, rbModel;
    Spinner spAsal;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNM = (EditText) findViewById(R.id.editTextNM);
        cbVocal = (CheckBox) findViewById(R.id.checkBoxVocal);
        cbDance = (CheckBox) findViewById(R.id.checkBoxDance);
        cbActing = (CheckBox) findViewById(R.id.checkBoxActing);
        cbCP = (CheckBox) findViewById(R.id.checkBoxCP);
        rbSolo = (RadioButton) findViewById(R.id.radioButtonSolo);
        rbGroup = (RadioButton) findViewById(R.id.radioButtonGroup);
        rbAA = (RadioButton) findViewById(R.id.radioButtonAA);
        rbModel = (RadioButton) findViewById(R.id.radioButtonModel);
        spAsal = (Spinner) findViewById(R.id.spinner);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View v) {
                                                               doClick();
                                                           }
                                                       }
        );
    }

    private void doClick() {
        String nama = etNM.getText().toString();

        String hasil = null;

        if (rbSolo.isChecked()) {
            hasil = rbSolo.getText().toString();
        } else if (rbGroup.isChecked()) {
            hasil = rbGroup.getText().toString();
        } else if (rbAA.isChecked()) {
            hasil = rbAA.getText().toString();
        } else if (rbModel.isChecked()) {
            hasil = rbModel.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Pilih keinginan debut anda");
        } else {
            tvHasil.setText("Anda berkeinginan debut untuk menjadi " + hasil);
        }

        String ahli = "Anda memilh keahlian : \n";
        int startlen = ahli.length();
        if (cbVocal.isChecked()) ahli += cbVocal.getText() + "\n";
        if (cbDance.isChecked()) ahli += cbDance.getText() + "\n";
        if (cbActing.isChecked()) ahli += cbActing.getText() + "\n";
        if (cbCP.isChecked()) ahli += cbCP.getText() + "\n";
        if (ahli.length() == startlen) ahli += "Pilih keahlian anda";
        tvHasil.setText("Selamat datang " + nama + "\n Anda berkeinginan debut sebagai " + hasil + "\nNegara asal " + spAsal.getSelectedItem().toString());
    }
}
