package com.example.map;//package com.yandex.mapkitdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.mapkit.places.Places;
import com.yandex.mapkit.places.panorama.Player;

import static java.lang.Double.valueOf;
/**
 * В этом примере показывается карта и камера выставляется на указанную точку.
 * Не забудьте запросить необходимые разрешения.
 */
public class Main2Activity extends AppCompatActivity {
    /**
     * Замените "your_api_key" валидным API-ключом.
     * Ключ можно получить на сайте https://developer.tech.yandex.ru/
     */
    private final String MAPKIT_API_KEY = "acd81c91-1fbd-449e-8b33-fe87e80cef68";


    private Point TARGET_LOCATION = new Point(59.945933, 30.320045);

    native Places getInstance();
    void	initialize(Context context){};
    public void onPanoramaDirectionChanged (@NonNull Player player){};
    private MapView mapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        MapKitFactory.setApiKey(MAPKIT_API_KEY);


        MapKitFactory.initialize(this);

        setContentView(R.layout.activity_main2);
        super.onCreate(savedInstanceState);

        // im.setText(MyLocationListener.imHere.toString());

    }
     @Override
    protected void onStop() {
        // Вызов onStop нужно передавать инстансам MapView и MapKit.
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onStart() {
        // Вызов onStart нужно передавать инстансам MapView и MapKit.
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }


    public void onClick(View view) {
        Intent i =getIntent();
      int e1= i.getIntArrayExtra("ed")[0];
      int e2= i.getIntArrayExtra("ed")[1];
      mapView = (MapView)findViewById(R.id.mapview);
        Button but = (Button)findViewById(R.id.but);
        // Button b1 = (Button) findViewById(R.id.button2);
        // String s[] = getIntent().getExtras().getString("ed").split(" ");
        final Point TARGET_LOCATION = new Point(e1, e2);
        mapView.getMap().move(
                new CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
                new Animation(Animation.Type.SMOOTH, 5),
                null);
    }


}


