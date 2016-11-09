package francisco.villalba.parcial.facitec.edu.py.op2final;

import java.util.List;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class AdapterBat extends BaseAdapter {

    private Context context;
    private List<Batman> batman;

    public AdapterBat(Context context, List<Batman> batman) {
        this.context = context;
        this.batman = batman;
    }

    @Override
    public int getCount() {
        return this.batman.size();
    }

    @Override
    public Object getItem(int position) {
        return this.batman.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (convertView == null) {
            // Create a new view into the list.
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.item_layout, parent, false);
        }



        Batman a = this.batman.get(position);

        TextView textViewTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView textViewYear = (TextView) rowView.findViewById(R.id.textViewYear);
        TextView textViewType = (TextView) rowView.findViewById(R.id.textViewType);
        ImageView PosterImageView = (ImageView) rowView.findViewById(R.id.imageViewPoster);

        Picasso.with(this.context).load(a.getPoster()).into(PosterImageView);

        textViewTitle.setText(a.getTitle());
        textViewYear.setText(a.getYear());
        textViewType.setText(a.getType());


        return rowView;
    }
}
