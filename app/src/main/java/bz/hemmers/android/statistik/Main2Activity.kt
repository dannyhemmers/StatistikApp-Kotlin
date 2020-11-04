package bz.hemmers.android.statistik

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.view.View
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class Main2Activity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)



        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        val fm : FragmentManager = getSupportFragmentManager()


        val bFragment : BinomialFragment = BinomialFragment()



        fm.beginTransaction().replace(R.id.content_frame,  bFragment).commit()


    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        //menuInflater.inflate(R.menu.main2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val id = item.itemId

        var fm : FragmentManager = supportFragmentManager

        if(id == R.id.binomial)
        {
            var binomialFragment : BinomialFragment = BinomialFragment()
            fm.beginTransaction().replace(R.id.content_frame, binomialFragment).commit()
        }
        else if(id == R.id.hypergeo)
        {
            var hypergeoFragment : HypergeoFragment = HypergeoFragment()
            fm.beginTransaction().replace(R.id.content_frame, hypergeoFragment).commit()
        }
        else if(id == R.id.geo)
        {
            var geoFragment : GeoFragment = GeoFragment()
            fm.beginTransaction().replace(R.id.content_frame, geoFragment).commit()
        }
        else if(id == R.id.poisson)
        {
            var poissonFragment : PoissonFragment = PoissonFragment()
            fm.beginTransaction().replace(R.id.content_frame, poissonFragment).commit()
        }
        else if(id == R.id.exponential)
        {
            var exponentialFragment : ExponentialFragment = ExponentialFragment()
            fm.beginTransaction().replace(R.id.content_frame, exponentialFragment).commit()
        }


        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
