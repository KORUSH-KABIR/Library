# MyWorkerLibrary

[![](https://jitpack.io/v/KORUSH-KABIR/Library.svg)](https://jitpack.io/#KORUSH-KABIR/Library)

# Step 1. Add the JitPack repository to your build file 

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  # Step 2. Add the dependency
  
  	dependencies {
	        implementation 'com.github.KORUSH-KABIR:Library:2.0.5'
	}
	

//////////////////////////////////////////////////////////////////////////////


# 1. Sample SharedPreferenceUtils Class:

        SharedPreferenceUtils utils = new SharedPreferenceUtils(this);
        utils.writeString  ("key" , "text" );
        utils.writeBoolean ("key" , true   );
        utils.writeFloat   ("key" , 1.85F  );
        utils.writeInteger ("key" , 85     );
        utils.writeLong    ("key" , 85L    );
	

//////////////////////////////////////////////////////////////////////////////
	
	
# 2. Sample ConnectionHelper Class:

        String url = "https://...";
        int timeOut = 5000;
        new ConnectionHelper(url , timeOut)
                .addStringRequest("key" , "value")
                .addFileRequest("key" , "path")
                .getResponse(new OnGetResponse() {
                    @Override
                    public void notConnectToServer() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // can not connect to server
                                // use of mainTread
                            }
                        });
                    }

                    @Override
                    public void onSuccessResponse(String result) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // success to get
                                // use of mainTread
                            }
                        });
                    }

                    @Override
                    public void onNullResponse() {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // if result = null
                                // use of mainTread
                            }
                        });
                    }
                });


//////////////////////////////////////////////////////////////////////////////
	
	
# 3. Sample TabHelper Class:

        TabHelper tabHelper = new TabHelper(this , R.id.viewPager , R.id.tabLayout);
        TabHelper tabHelper = new TabHelper(this , view , R.id.viewPager , R.id.tabLayout); // find widget in view
        TabHelper tabHelper = new TabHelper(this , viewPager , tabLayout);

        tabHelper.add(Fragment.class , R.drawable.icon , "text");
        tabHelper.add(Fragment.class , R.drawable.icon);
        tabHelper.add(Fragment.class , "text");

	
//////////////////////////////////////////////////////////////////////////////


# 4. Sample LanguageUtils Class:

        LanguageUtils.changeLanguage(
                getResources() ,
                LanguageUtils.PERSIAN // get Persian resources (fa)
        );

        LanguageUtils.changeLanguage(
                getResources() ,
                LanguageUtils.ENGLISH // get English resources (en)
        );

	
//////////////////////////////////////////////////////////////////////////////


# 5. Sample FlasherImageView Class:

in xml:
    
    <ir.aid.library.Frameworks.widget.FlasherImageView
        android:id="@+id/fiv"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:fimDefaultColor="#200000"
        app:fimFirstColor="#E91E63"
        app:fimSecondColor="#4CAF50"
        app:fimStartAutoChange="false"
        app:fimTimeChangeColor="4000" />
	
in java:

        FlasherImageView flasherImageView = findViewById(R.id.fiv);
        flasherImageView.autoChange(true);
        flasherImageView.start();
        flasherImageView.stop();

