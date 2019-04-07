package com.example.peter.pryanikchallenge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.peter.pryanikchallenge.delegate.SelectorAdapter;
import com.example.peter.pryanikchallenge.models.Base;
import com.example.peter.pryanikchallenge.models.Data;
import com.example.peter.pryanikchallenge.models.DataStruct;
import com.example.peter.pryanikchallenge.models.Variant;
import com.example.peter.pryanikchallenge.utils.DataUtils;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @NonNull
    private Context context;
    @NonNull
    private List<DataStruct> list;
    @NonNull
    private List<String> view;
    @NonNull
    private OnItemClickListener listener;


    public Adapter(@NonNull Context context, @NonNull Base base, @NonNull OnItemClickListener listener) {
        this.context = context;
        this.listener = listener;
        list = DataUtils.convertToList(base);
        view = DataUtils.baseToView(base);
    }

    @Override
    public int getItemViewType(int position) {
        TypeView type = TypeView.valueOf(view.get(position));

        switch (type){
            case hz:
            return R.layout.hz_tem;

            case picture:
            return R.layout.pic_item;

            case selector:
            return R.layout.selector_item;
            default:
                try {
                    throw new IllegalAccessException("Can't find view type by position " + position);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
        }
            return R.layout.hz_tem;

       }



    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
      //  RecyclerView.ViewHolder viewHolder;


        switch (viewType){
            case R.layout.selector_item:
                return new SelectorHolder(LayoutInflater.from(context).inflate(R.layout.selector_item,viewGroup,false));
            case R.layout.pic_item:
                return new PictureHolder(LayoutInflater.from(context).inflate(R.layout.pic_item, viewGroup,false));
            case R.layout.hz_tem:
                return new HzHolder(LayoutInflater.from(context).inflate(R.layout.hz_tem,viewGroup,false));
             default:
                 throw new IllegalArgumentException(
                         "Can't create view holder from view type " + viewType);

        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        String variant = view.get(position);
        int pos = DataUtils.getStructPosition(variant,list);
        DataStruct dataStr = list.get(pos);

        switch (this.getItemViewType(position)){
        case R.layout.selector_item:
            SelectorHolder selectorHolder = (SelectorHolder) viewHolder;
            selectorHolder.bind(pos, dataStr);
            break;
        case R.layout.pic_item:
          //  int pos = DataUtils.getStructPosition(variant,list);
            PictureHolder picholder = (PictureHolder) viewHolder;
            picholder.bind(pos, dataStr);
            break;
        case R.layout.hz_tem:
            HzHolder hzHolder = (HzHolder) viewHolder;
            hzHolder.bind(pos, dataStr);
            break;
        default:
            throw new IllegalArgumentException(
                    "Can't create bind holder fro position " + position);
    }
    }

    @Override
    public int getItemCount() {
        return view.size();
    }

     class HzHolder extends RecyclerView.ViewHolder{

        final private TextView hzText;
        final private ConstraintLayout hzLay;

        public HzHolder(@NonNull View itemView) {
            super(itemView);
            hzText = itemView.findViewById(R.id.text_hz);
            hzLay = itemView.findViewById(R.id.hz_layout);

        }

        private void bind(int position, final DataStruct dataStr){
        hzText.setText(list.get(position).getData().getText());
        hzLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onItemClick(v,dataStr);
            }
        });
        }
    }

    class SelectorHolder extends RecyclerView.ViewHolder{
         private Spinner spinner;

        public SelectorHolder(@NonNull View itemView) {
            super(itemView);
            spinner = itemView.findViewById(R.id.spinner);

        }

        private void bind(int position, final DataStruct dataStr){
            List<Variant> variants = list.get(position).getData().getVariants();
            final List<String> selectList = DataUtils.fillVariants(variants);


            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_spinner_item, selectList);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);
            spinner.setSelection(DataUtils.getPos(selectList));
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                listener.onItemSelect(view,dataStr,i);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
    }

    class PictureHolder extends RecyclerView.ViewHolder{
           final private ImageView image;
           final private TextView textDesc;
           final private ConstraintLayout picLayout;

        public PictureHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            textDesc = itemView.findViewById(R.id.text_describtion);
            picLayout = itemView.findViewById(R.id.pic_layout);
        }

        private void bind(int position,final DataStruct dataStr){
           textDesc.setText(list.get(position).getData().getText());

            Glide.with(context)
                    .load(list.get(position).getData().getUrl())
                    .placeholder(R.drawable.ic_block_black)
                    .into(image);

            picLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                listener.onItemClick(v,dataStr);
                }
            });

        }
    }

    private enum TypeView {
        hz,
        picture,
        selector
    }

    public interface OnItemClickListener{
        void onItemClick(View view, DataStruct data);
        void onItemSelect(View view, DataStruct data, int position);
    }
}


