package br.com.inteliprojects.passaregua;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
   
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.inteliprojects.passaregua.itens.ItemView;
import br.com.inteliprojects.passaregua.itens.ItemViewListAdapter;
import br.com.inteliprojects.passaregua.itens.model.ItemModel;

public class Principal extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() );

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //numItem = 1;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "SECTION " + (position + 1);
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        List<ItemView> lsItemView;

        public PlaceholderFragment(){
            lsItemView = new ArrayList<ItemView>();
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_principal, container, false);

            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            if (sectionNumber == 1) {

            }

            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText( getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER) ) );

//            TextView txtButton = (TextView) rootView.findViewById(R.id.txtViewAdicionar);
//
//            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
//            if (sectionNumber != 1) {
//                txtButton.setVisibility(View.INVISIBLE);
//            } else {
//                txtButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Log.i("SavedInstance", "Inserindo Item ... ");
//
//                        //LinearLayout layout = (LinearLayout) rootView.findViewById(R.id.LayoutPrincipal);
//                        ItemView item = new ItemView( rootView.getContext(), getItemModel() );
//                        lsItemView.add(item);
//
//                        ListView layout = (ListView) rootView.findViewById(R.id.ListViewPrincipal);
//                        layout.setAdapter(new ItemViewListAdapter(rootView.getContext(), lsItemView));
//                    }
//                });
//            }

            return rootView;
        }
    }

    static int numItem = 1;
    private static ItemModel getItemModel() {
        Random rand = new Random();
        String arrProdutos[] = {"Churrasquinho", "Coca-Cola", "Sorvete", "Bife", "Coquetel Havaiano", "Batatas Frita"};

        ItemModel itemModel = new ItemModel(
                numItem, arrProdutos[rand.nextInt(5)],
                rand.nextInt(4) + 1, "Und",
                new BigDecimal( ( (1 + rand.nextInt(200))/10 ) + 0.3 ));

        numItem ++;
        return itemModel;
    }
}
