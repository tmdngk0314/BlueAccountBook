package com.cookandroid.account_book;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class MemoActivity extends AppCompatActivity {

    MemoSqlite dbHelper;

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Button btnAdd;

    List<Memo> memoList; //리사이클러뷰에 들어갈 전역변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);

        Intent intent3 = getIntent();
        dbHelper = new MemoSqlite(MemoActivity.this);
        memoList = dbHelper.selectAll();
        //리사이클러뷰에 연결해두었던 memoList에 DB에서 가져온 리스트를 넣어줌

        recyclerView = findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MemoActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerAdapter = new RecyclerAdapter(memoList);
        recyclerView.setAdapter(recyclerAdapter);  //리사이클러 뷰와 어댑터를 연결해줌
        btnAdd= findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //새로운 메모 작성
                Intent memointent = new Intent(MemoActivity.this,MemoAddActivity.class);
                //intent를 사용해 메모를 MemoActivity에 불러옴
                startActivityForResult(memointent, 0);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //startACtivityForResult로 실행한 액티비티가 끝났을때 데이터를 받는다
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            //startActivityForResult에 넣은 requestCode와 같을때
            String strMain = data.getStringExtra("main");
            String strSub = data.getStringExtra("sub");
            //데이터를 받는다

            Memo memo = new Memo(strMain,strSub,0);
            //받아온 데이터로 메모를 만든다
            recyclerAdapter.addItem(memo);
            //생성된 메모 추가
            recyclerAdapter.notifyDataSetChanged();

            dbHelper.insertMemo(memo);
        }
    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{ //어댑터 생성

        private List<Memo> listdata;  //배열로 데이터들을 받는다

        public RecyclerAdapter(List<Memo> listdata){
            this.listdata = listdata;
        }

        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate
                    (R.layout.activity_list_item, viewGroup,false);
            return new ItemViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        } //아이템 개수를 반환

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
            Memo memo = listdata.get(i);

            itemViewHolder.maintext.setTag(memo.getSeq());

            itemViewHolder.maintext.setText(memo.getMaintext());
            //메인텍스트에 Memo의 메인텍스트를 넣는다
            itemViewHolder.subtext.setText(memo.getSubtext());
            //서브텍스트에 Memo의 서브텍스트를 넣는다

        }   //데이터를 레이아웃에 어떻게 넣어줄지 정한다.

        void addItem(Memo memo){
            listdata.add(memo);
        } //리스트 추가

        void removeItem(int position){
            listdata.remove(position);
        }  //리스트 제거



        class ItemViewHolder extends RecyclerView.ViewHolder{

            private TextView maintext;
            private TextView subtext;
            private ImageView img;

            public ItemViewHolder(@NonNull View itemView){
                super(itemView);

                maintext = itemView.findViewById(R.id.item_maintext);
                subtext = itemView.findViewById(R.id.item_subtext);
                img = itemView.findViewById(R.id.item_image);

                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {

                        int position = getAdapterPosition();
                        int seq = (int)maintext.getTag();

                        if(position  != RecyclerView.NO_POSITION){
                            dbHelper.deleteMemo(seq);
                            removeItem(position);
                            notifyDataSetChanged();
                        }
                        return false;
                    }
                });
            }

        }


    }


}


