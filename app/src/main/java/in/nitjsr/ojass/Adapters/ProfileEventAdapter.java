package in.nitjsr.ojass.Adapters;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import in.nitjsr.ojass.Modals.Modal;
import in.nitjsr.ojass.R;

/**
 * Created by Abhishek on 30-Jan-18.
 */

public class ProfileEventAdapter extends RecyclerView.Adapter<ProfileEventAdapter.ViewHolder> {

    private ArrayList<Modal> dataset;
    private Context context;

    public ProfileEventAdapter(Context context, ArrayList<Modal> dataset){
        this.context = context;
        this.dataset = dataset;
    }

    @Override
    public ProfileEventAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_profile_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileEventAdapter.ViewHolder holder, int position) {
        Modal current = dataset.get(position);
        Picasso.with(context).load(current.getImage()).fit().into(holder.ivEvent);
        holder.tvEventName.setText(current.getEventName());
        holder.tvTeamName.setText(current.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivEvent;
        private TextView tvEventName, tvTeamName, tvEventParticipants, tvEventResult;

        public ViewHolder(View itemView) {
            super(itemView);
            ivEvent = itemView.findViewById(R.id.iv_profile_event_img);
            tvEventName = itemView.findViewById(R.id.tv_profile_event_name);
            tvTeamName = itemView.findViewById(R.id.tv_profile_team_name);
            tvEventParticipants = itemView.findViewById(R.id.tv_profile_event_participant);
            tvEventResult  = itemView.findViewById(R.id.tv_profile_team_result);
        }
    }
}
