package com.appsinnovate.myapplication.ui.fragments.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.appsinnovate.myapplication.model.DetailsObject;
import com.appsinnovate.myapplication.network.ApiClient;
import com.appsinnovate.myapplication.network.ApiService;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DetailsViewModel extends ViewModel {
    private Disposable disposable;
    private MutableLiveData<DetailsObject> _detailsObjectMutableLiveData = new MutableLiveData<>();
    public LiveData<DetailsObject> detailsObjectLiveData = _detailsObjectMutableLiveData;

    DetailsViewModel(int id) {
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Single.zip(service.getFlag(id), service.getInfo(id), service.getImages(id),
                (flagResponseModel, countryInfoResponseModel, countryImagesResponseModel) ->
                        new DetailsObject(countryInfoResponseModel,
                                countryImagesResponseModel,
                                flagResponseModel))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<DetailsObject>() {
                    @Override
                    public void onSuccess(DetailsObject detailsObject) {
                        _detailsObjectMutableLiveData.setValue(detailsObject);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}