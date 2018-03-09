package imastudio.co.id.anroidroom.ui.add;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import imastudio.co.id.anroidroom.R;
import imastudio.co.id.anroidroom.db.model.ModelPeserta;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.edtNama)
    EditText edtNama;
    @BindView(R.id.edtPelatihan)
    EditText edtPelatihan;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    AddViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(AddViewModel.class);
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {
        String nama = edtNama.getText().toString();
        String pelatihan = edtPelatihan.getText().toString();
        if (nama.isEmpty() && pelatihan.isEmpty()) {
            Toast.makeText(AddActivity.this, "Masih Kosong", Toast.LENGTH_SHORT).show();
        } else {
            viewModel.addPeserta(new ModelPeserta(nama, pelatihan));
            Toast.makeText(this, "Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}

