package dz.da3sou9a.oualaeddine.lmdulator.activities.charts;

import android.support.v7.app.AppCompatActivity;

public class ChartPieFragment extends AppCompatActivity {
  /**  TextView t_17,t_15,t_12,t_10,t_5,t_0,moyen;
    ModulesTableManager helper; ArrayList<Double> notes;int student_id;
    private float[] yData ;
    private String[] xData = {"17 - 20", "15 - 17" , "12 - 15" , "10 - 12", "5 - 10", "0 - 5"};
    private String[] pColor={"#FFB300","#00BFA5","#82B1FF","#FFD180","#FF80AB","#FF8A80"};
    PieChart pieChart;
    int _17=0,_15=0,_12=0,_10=0,_5=0,_0=0;
    double totalNotes=0;
    ArrayList<PieEntry> yEntrys ;
    ArrayList<String> xEntrys ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piechart);

        moyen= (TextView) findViewById(R.id.moyen);
        t_17= (TextView) findViewById(R.id._17);
        t_15= (TextView) findViewById(R.id._15);
        t_12= (TextView) findViewById(R.id._12);
        t_10= (TextView) findViewById(R.id._10);
        t_5= (TextView) findViewById(R.id._5);
        t_0= (TextView) findViewById(R.id._0);


        Intent intent = getIntent();
        student_id=intent.getIntExtra("student_id",0);
        helper=new ModulesTableManager(this);
        notes=helper.getModules(student_id,yearId);

        // for(int i=0;i<notes.size();i++){
        //   Log.e("notes ",notes.get(i).toString());
        //}
        for(int i=0;i<notes.size();i++){
            totalNotes+=notes.get(i);
            double current = Double.parseDouble(notes.get(i).toString());
            if(current>=17 && current<=20){
                _17++;
            }
            if(current>=15 && current<17){
                _15++;
            }
            if(current>=12 && current<15){
                _12++;
            }
            if(current>=10 && current<12){
                _10++;
            }
            if(current>=5 && current<10){
                _5++;
            }
            if(current>=0 && current<5){
                _0++;
            }
        }
        yData = new float[]{_17*100f/notes.size(), _15*100f/notes.size(), _12*100f/notes.size(), _10*100f/notes.size(), _5*100f/notes.size(), _0*100f/notes.size()};
        pieChart = (PieChart) findViewById(R.id.chart1);
        pieChart.getDescription().setEnabled(false);
        pieChart.setRotationEnabled(true);
        //pieChart.setUsePercentValues(true);
        pieChart.setHoleColor(ContextCompat.getColor(this,R.color.colorPrimary));
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Score");
        pieChart.setCenterTextSize(10);
        //pieChart.setDrawEntryLabels(true);
        //pieChart.setEntryLabelTextSize(20);
        //More options just check out the documentation!
        addDataSet();
        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                String TAG="bla bla wail :";
                Log.d(TAG, "onValueSelected: Value select from chart.");
                Log.d(TAG, "onValueSelected: " + e.toString());
                Log.d(TAG, "onValueSelected: " + h.toString());
                int pos1 = h.toString().indexOf("x:");
                String sales = h.toString().substring(pos1 + 3);
                sales=sales.substring(0,1);
                Log.e("sales",sales);
                String txt = xEntrys.get(Integer.parseInt(sales));
                switch (txt){
                    case "17 - 20" :
                        t_17.setBackgroundResource(R.drawable.shape5);
                        t_17.setTextColor(Color.BLACK);
                        t_17.setGravity(Gravity.CENTER);
                        restore(t_17);
                        break;
                    case "15 - 17" :
                        t_15.setBackgroundResource(R.drawable.shape5);
                        t_15.setTextColor(Color.BLACK);
                        t_15.setGravity(Gravity.CENTER);
                        restore(t_15);
                        break;
                    case "12 - 15" :
                        t_12.setBackgroundResource(R.drawable.shape5);
                        t_12.setTextColor(Color.BLACK);
                        t_12.setGravity(Gravity.CENTER);
                        restore(t_12);
                        break;
                    case "10 - 12" :
                        t_10.setBackgroundResource(R.drawable.shape5);
                        t_10.setTextColor(Color.BLACK);
                        t_10.setGravity(Gravity.CENTER);
                        restore(t_10);
                        break;
                    case "5 - 10" :
                        t_5.setBackgroundResource(R.drawable.shape5);
                        t_5.setTextColor(Color.BLACK);
                        t_5.setGravity(Gravity.CENTER);
                        restore(t_5);
                        break;
                    case "0 - 5" :
                        t_0.setBackgroundResource(R.drawable.shape5);
                        t_0.setTextColor(Color.BLACK);
                        t_0.setGravity(Gravity.CENTER);
                        restore(t_0);

                        break;

                }
                Toast.makeText(ChartPieFragment.this, "U r in : "+txt, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected() {
                restore(new TextView(getBaseContext()));
            }
        });
        t_0.setText(""+_0);
        t_5.setText(""+_5);
        t_10.setText(""+_10);
        t_12.setText(""+_12);
        t_15.setText(""+_15);
        t_17.setText(""+_17);

        double moy = calculMoyen();

        if(moy!=99){
            String text=moy+"";
            if(text.length()>6){
                text = text.substring(0, 6);
            }
            moyen.setText(text+" /20");
        }else {
            moyen.setText(".. / 20");
        }
}


    private void addDataSet() {
        yEntrys = new ArrayList<>();
        xEntrys = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            if(yData[i]!=0){
                yEntrys.add(new PieEntry(yData[i] , i));
                xEntrys.add(xData[i]);
                colors.add(Color.parseColor(pColor[i]));
            }
        }


        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Student Score");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to dataset
        pieDataSet.setColors(colors);

        //add legend to chart
        /*Legend l = pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);*/

/**
        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }**/}