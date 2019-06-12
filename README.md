# GSE-Inshorts
A part of the hiring process for GSE-Red
This application does not contain UI as it was not asked for.

### Description of Project structure
The application is divided into 5 packages.
1. starter. (This package contains the main activity that contains the startup code of the application and init of the main viewpager for left-right swiping).
2. vertical_news. (This package contains ScreenSlideFragment that conatins the init of the fragment and the news view pager that supports the top-bottom swiping. It also contains the NewsModel tat is a pojo for the news. Adapter for news data loading. And a view model that does nothing at the moment.).
3. setting_tab. (This package contains the init code for settings fragment that appears on left swiping. It contains the code for search toolbar animation.).
4. detail_tab. (This package contains the init for detail page. This is currently empty at the moment).
5. util. (This package contains the code for the transfor that can be used with viewpager. Currently it is not employed. This package also contains the code for retrieving network status).

### Features
This projects shows one of the functionalaties of the Inshorts app, ei, Multi-direction swiping.
All features included in the app are:

1. The layout support to show the settings screen (at 0 position), news screen (at 1 position) and detail screen (at 2 position) which supports left-right swiping of fragments.
2. The layout supports Top-bottom swiping of the news cards.
3. On main screen click, you can see the bottom action layout transating up for more actions for the user.
4. On settings screen, you can click on the search view and it animates to a toolbar for searching.


### Screenshots

<img src="https://github.com/DhruvamSharma/GSE-Inshorts/blob/master/docs/main_screen.png" height=500 width=300> <img src="https://github.com/DhruvamSharma/GSE-Inshorts/blob/master/docs/main_screen_after_click.png" height=500 width=300>

<img src="https://github.com/DhruvamSharma/GSE-Inshorts/blob/master/docs/settings_screen.png" height=500 width=300> <img src="https://github.com/DhruvamSharma/GSE-Inshorts/blob/master/docs/settings_screen_after_animation.png" height=500 width=300>
