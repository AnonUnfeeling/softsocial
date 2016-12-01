package jdroidcoder.ua.sgsocialnetwork.jdroidcoder.activitys;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.fragments.GlobalSpamFragment;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.fragments.ListViewFragment;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.fragments.ProfileFragment;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.models.ContactModel;
import jdroidcoder.ua.sgsocialnetwork.jdroidcoder.models.UserModel;
import jdroidcoder.ua.sgsocialnetwork.sgMessenger.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private GlobalSpamFragment globalSpamFragment = null;
    private ProfileFragment profileFragment;
    private FloatingActionButton fab;
    private FragmentManager fragmentManager = null;
    public static Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        showContactList();

        RealmList<ContactModel> emails = new RealmList<>();
        emails.add(new ContactModel("email@email", "work"));

        RealmList<ContactModel> phones = new RealmList<>();
        phones.add(new ContactModel("(096) 9824168", "personal"));

        UserModel userModel = new UserModel("Ivan", "Petro", "Developer", "15", phones, emails);
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        realm = Realm.getInstance(config);
//        realm.beginTransaction();
//        realm.insert(userModel);
//        realm.commitTransaction();
        System.out.println(realm.where(UserModel.class).findFirst());
    }

    private void showContactList() {
        fragmentManager.beginTransaction().replace(R.id.main_flagment_layout, new ListViewFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (profileFragment != null) {
            removeFragment(profileFragment);
            profileFragment = null;
        } else if (globalSpamFragment != null) {
            removeFragment(globalSpamFragment);
            globalSpamFragment = null;
        } else {
            super.onBackPressed();
        }
    }

    private void removeFragment(Fragment fragment) {
        setTitle(getResources().getString(R.string.app_name));
        fab.setVisibility(View.VISIBLE);
        fragmentManager.beginTransaction().remove(fragment).commit();
        showContactList();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.showProfile) {
            if (profileFragment == null) {
                fab.setVisibility(View.GONE);
                profileFragment = new ProfileFragment();
                fragmentManager.beginTransaction().replace(R.id.main_flagment_layout, profileFragment).commit();
            } else {
                removeFragment(profileFragment);
                profileFragment = null;
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        if (globalSpamFragment == null) {
            fab.setVisibility(View.GONE);
            globalSpamFragment = new GlobalSpamFragment();
            fragmentManager.beginTransaction().replace(R.id.main_flagment_layout, globalSpamFragment).commit();
        } else {
            removeFragment(profileFragment);
            globalSpamFragment = null;
        }
    }
}
