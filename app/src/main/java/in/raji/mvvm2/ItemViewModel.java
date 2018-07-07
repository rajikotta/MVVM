package in.raji.mvvm2;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

public class ItemViewModel extends AndroidViewModel {
     public ItemViewModel(@NonNull Application application) {
        super(application);
        itemModel=new MutableLiveData<>();
    }
    private MutableLiveData<ItemModel> itemModel;

    public MutableLiveData<ItemModel> getItemModel() {
        return itemModel;
    }

    public void setItemModel(MutableLiveData<ItemModel> itemModel) {
        this.itemModel = itemModel;
    }
}
