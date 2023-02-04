package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DiasUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do Pacote");

        Pacote pacote = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.activity_resumo_pacote_local);
        local.setText(pacote.getLocal());

        TextView dias = findViewById(R.id.activity_resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);

        TextView preco = findViewById(R.id.activity_resumo_pacote_preco);
        String precoEmTexto = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(precoEmTexto);


        ImageView image = findViewById(R.id.activity_resumo_pacote_imagem);
        Drawable drawableDevolvido = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        image.setImageDrawable(drawableDevolvido);


        TextView data = findViewById(R.id.activity_resumo_pacote_data);

        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();


        dataVolta.add(Calendar.DATE, pacote.getDias());
        SimpleDateFormat formatoBrasileiroData = new SimpleDateFormat("dd/MM");

        String dataFormatadaIda = formatoBrasileiroData.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiroData.format(dataVolta.getTime());
        String dataFormatadaDaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);

        data.setText(dataFormatadaDaViagem);

    }
}