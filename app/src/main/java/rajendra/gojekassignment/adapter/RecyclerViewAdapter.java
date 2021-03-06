package rajendra.gojekassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;
import rajendra.gojekassignment.R;
import rajendra.gojekassignment.model.GitRepo;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<GitRepo> mData ;

    public RecyclerViewAdapter(Context mContext, List<GitRepo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Glide.with(mContext)
                .load(mData.get(position).getAvatar())
                .into(holder.Aavatar);


        holder.Aauthor.setText(mData.get(position).getAuthor());
        holder.Aname.setText(mData.get(position).getName());
        holder.Lang.setText(mData.get(position).getLanguage());
        holder.Stars.setText(mData.get(position).getStars().toString());
        holder.Forks.setText(mData.get(position).getForks().toString());



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView Aauthor,Aname,Lang,Stars,Forks ;
        View Langcolor;
        CircleImageView Aavatar;
        LinearLayout view_container, collapse;


        public MyViewHolder(View itemView) {
            super(itemView);

            collapse = itemView.findViewById(R.id.collapse);
            view_container = itemView.findViewById(R.id.container);
            Aavatar = itemView.findViewById(R.id.avatar);
            Aauthor = itemView.findViewById(R.id.author);
            Aname = itemView.findViewById(R.id.name);
            Lang= itemView.findViewById(R.id.lang);
            Stars= itemView.findViewById(R.id.stars);
            Forks= itemView.findViewById(R.id.forks);
            Langcolor = itemView.findViewById(R.id.color);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(collapse.getVisibility()==View.VISIBLE)
            {
                collapse.setVisibility(View.GONE);

            }
            else{collapse.setVisibility(View.VISIBLE);}

        }
    }

}

