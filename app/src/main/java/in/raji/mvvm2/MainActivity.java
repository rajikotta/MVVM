package in.raji.mvvm2;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import in.raji.mvvm2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        et = (EditText) findViewById(R.id.edit_query);
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        binding.setItem(itemViewModel);

        Observer<ItemModel> observer = new Observer<ItemModel>() {
            @Override
            public void onChanged(@Nullable ItemModel itemModel) {
                binding.setItemValue(itemModel);
            }
        };
        itemViewModel.getItemModel().observe(this, observer);

    }
}
