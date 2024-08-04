package com.example.sqlite_sugarormexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;

public class MainActivity extends ListActivity implements View.OnClickListener {

    int count = 0;
    ArrayAdapter<Person> adapter;
    List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy hết danh sách people, nhét vào List tương ứng.
        people = Person.listAll(Person.class);

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, people);
        setListAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.delete_all) {
            // Xoá tất cả các phần tử trong bảng Person.
            Person.deleteAll(Person.class);
            // Và xoá luôn trong danh sách.
            people.clear();
            refresh();
        }

        if (view.getId() == R.id.add) {
            count++;
            Person p = new Person("A " + String.valueOf(count), count);
            // Lưu record mới vào DB.
            p.save();
            // Thêm vào danh sách để hiển thị màn hình.
            people.add(p);
            refresh();
        }
    }

    // Thông báo cho adapter rằng danh sách các phần tử đã thay đổi.
    private void refresh() {
        adapter.notifyDataSetChanged();
    }
}