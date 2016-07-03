package com.epicodus.sportstats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TeamsActivity extends AppCompatActivity {
    @Bind(R.id.lvTeams) ListView mListTeams;
    @Bind(R.id.lvScores) ListView mListScores;
    @Bind(R.id.tvUsername) TextView mUsername;

    private String[] teams = new String[] {"Switzerland vs Poland", "Wales vs N.Ireland", "Croatia vs Portugal", "France vs Ireland", "Germany vs Slovakia", "Hungry vs Belgium", "Italy vs Spain", "England vs Iceland", "Poland vs Portugal", "Wales vs Belgium"};
    private String[] scores = new String[] {"1 - 1", "1 - 0", "0 - 1", "2 - 1", "3 - 0", "0 - 4", "2 - 0", "1 - 2", "1 - 1", "3 - 1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        ButterKnife.bind(this);

        mUsername = (TextView) findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        mUsername.setText("Here is the text: " + username);

        mListTeams = (ListView) findViewById(R.id.lvTeams);
        mListScores = (ListView) findViewById(R.id.lvScores);

        ArrayAdapter adapterTeams = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, teams);
        ArrayAdapter adapterScores = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, scores);

        mListTeams.setAdapter(adapterTeams);
        mListScores.setAdapter(adapterScores);

    }
}
