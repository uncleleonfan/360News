package com.leon.a360news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    RecyclerView mRecyclerView;

    List<ResultBean.DataBean> mDataList = new ArrayList<ResultBean.DataBean>();

    Gson mGson = new Gson();

    NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mNewsAdapter = new NewsAdapter(this, mDataList);
        mRecyclerView.setAdapter(mNewsAdapter);
        mRecyclerView.addItemDecoration(new LineDecoration());
        getRemoteData();
    }

    private void getRemoteData() {
        OkHttpUtils.get()
                .url("http://10.0.2.2:8080/360/list1.json")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        Toast.makeText(MainActivity.this, "onError " + e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Toast.makeText(MainActivity.this, "onSuccess", Toast.LENGTH_SHORT).show();
                        ResultBean resultBean = mGson.fromJson(response, ResultBean.class);
                        mDataList.addAll(resultBean.getData());
                        mNewsAdapter.notifyDataSetChanged();
                    }
                });
    }
}
