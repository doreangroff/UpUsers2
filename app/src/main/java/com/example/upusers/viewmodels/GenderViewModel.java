package com.example.upusers.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.upusers.database.Database;
import com.example.upusers.database.dao.GenderDao;
import com.example.upusers.database.entites.Gender;

import java.util.List;

public class GenderViewModel extends AndroidViewModel {
    private GenderDao genderDao;
    private LiveData<List<Gender>> allData;
    private LiveData<Gender> genderAt;
    public GenderViewModel(Application application){
        super(application);
        Database database = Database.getDatabase(application);
        genderDao = database.genderDao();
        allData = genderDao.getAllGenders();
    }
    public LiveData<List<Gender>> getAllData(){return  allData;}
    public LiveData<Gender> getGenderAt(long id)
    {
        genderAt = genderDao.getGenderAt(id);
        return genderAt;
    }
    public void insert(Gender gender)
    {
        genderDao.insert(gender);
    }
    public void update(Gender gender)
    {
        genderDao.update(gender);
    }
    public void delete(Gender gender)
    {
        genderDao.delete(gender);
    }
}
