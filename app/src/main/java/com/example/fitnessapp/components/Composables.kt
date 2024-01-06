package com.example.fitnessapp.components

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.fitnessapp.R
import com.example.fitnessapp.ui.theme.FitnessAppTheme



@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun SearchBar(modifier: Modifier = Modifier){
    var text by remember{ mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },

                leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search, contentDescription
                = null
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
    )

}
@Composable
fun AlignYourBody(modifier: Modifier = Modifier,
                  @DrawableRes painter: Int,
                   @StringRes caption:Int){
    Column(modifier = modifier){
        Image(painter = painterResource(painter), contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(88.dp)
                .clip(CircleShape))
        Text(text = stringResource(caption),
            color = Color.Black,
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }


}
@Composable
fun  FavoriteCollectionCard(modifier: Modifier = Modifier,
                            @DrawableRes painter :Int,
                            @StringRes caption:Int){
    Surface (
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.onSecondaryContainer,
        modifier = modifier
    ){
        Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.width(255.dp)){
Image(painter = painterResource(painter), contentDescription =null, modifier = modifier.size(80.dp),
    contentScale = ContentScale.Crop)
            Text(text = stringResource(caption),

                style = MaterialTheme.typography.titleMedium,
                color = Color.White,

                modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}
@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier,
                    rowDataList: List<RowData>){
    LazyRow(modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ){
        items(rowDataList){
item -> AlignYourBody(painter = item.images, caption = item.text )
        }
    }
}
@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier,
                            gridList: List<FavoriteCollectionGrid>){
LazyHorizontalGrid(rows = GridCells.Fixed(2), modifier = modifier.height(168.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp),
    horizontalArrangement = Arrangement.spacedBy(16.dp),
    contentPadding = PaddingValues(horizontal = 16.dp),

){
    items(gridList){
        item -> FavoriteCollectionCard(painter = item.images, caption = item.text)
    }
}

}
@Composable
fun HomeSection(modifier: Modifier = Modifier,
               @StringRes title: Int, content: @Composable () -> Unit){
    Column(modifier = modifier){
        Text(text = stringResource(title),
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp),
            color = Color.Black)
        content()
    }

}
@Composable
fun HomeSections(modifier:Modifier = Modifier){
    Column(modifier = modifier.verticalScroll(rememberScrollState())){
        Spacer(modifier = modifier.height(16.dp))
        SearchBar(modifier = modifier.padding(horizontal = 16.dp))
   HomeSection(title = R.string.align_your_body) {
       AlignYourBodyRow(rowDataList = listOf(

           RowData(images = R.drawable.ab1_inversions, text = R.string.ab1_inversions),
           RowData(images = R.drawable.ab2_quick_yoga, text = R.string.ab2_quick_yoga),
           RowData(images = R.drawable.ab3_stretching, text = R.string.ab3_stretching),
           RowData(images = R.drawable.ab4_tabata, text = R.string.ab4_tabata),
           RowData(images = R.drawable.ab5_hiit, text = R.string.ab5_hiit),
           RowData(images = R.drawable.ab6_pre_natal_yoga, text = R.string.ab6_pre_natal_yoga),


           ))

   }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid(gridList = listOf( FavoriteCollectionGrid(images = R.drawable.fc1_short_mantras, text = R.string.fc1_short_mantras),
                FavoriteCollectionGrid(images = R.drawable.fc3_stress_and_anxiety, text = R.string.fc3_stress_and_anxiety),
                FavoriteCollectionGrid(images = R.drawable.fc5_overwhelmed, text = R.string.fc5_overwhelmed),
                FavoriteCollectionGrid(images = R.drawable.fc2_nature_meditations, text = R.string.fc2_nature_meditations),
                FavoriteCollectionGrid(images = R.drawable.fc4_self_massage, text = R.string.fc4_self_massage),
                FavoriteCollectionGrid(images = R.drawable.fc6_nightly_wind_down, text = R.string.fc6_nightly_wind_down)))
        }
        Spacer(modifier =modifier.height(16.dp))

    }
}
@Composable
 fun BottomNavigation(modifier:Modifier = Modifier){
    NavigationBar (modifier = modifier, containerColor =
    MaterialTheme.colorScheme.surfaceVariant){
NavigationBarItem(selected =true, onClick = {  }, icon = {
    // no spa icon
    Icon(imageVector = Icons.Default.Home, contentDescription = null)

},label= {
    Text(text = stringResource(id = R.string.bottom_navigation_home))
})

        NavigationBarItem(selected =true, onClick = {  }, icon = {
    // no spa icon
    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)

},
            label = {
                Text(stringResource(id = R.string.bottom_navigation_profile))
            }
    )

    }
}
@Composable
fun BottomNavigationRail(modifier:Modifier = Modifier){
    NavigationRail (modifier = modifier.padding(top = 8.dp, end = 8.dp), containerColor =
    MaterialTheme.colorScheme.background)
    {Column(modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ){
        NavigationRailItem(selected =true, onClick = {  }, icon = {
            // no spa icon
            Icon(imageVector = Icons.Default.Home, contentDescription = null)

        },label= {
            Text(text = stringResource(id = R.string.bottom_navigation_home))
        })
Spacer(modifier = modifier.height(8.dp))
        NavigationRailItem(selected =true, onClick = {  }, icon = {
            // no spa icon
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)

        },
            label = {
                Text(stringResource(id = R.string.bottom_navigation_profile))
            }
        )
    }


    }
}
@Composable
fun FitnessAppLandscape(){
Surface(color = MaterialTheme.colorScheme.background){
    Row{
        BottomNavigationRail()
        HomeSections()
    }
}
}
@Composable
fun FitnessApp(windowSize: WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
FitnessAppPotrait()
        }
        WindowWidthSizeClass.Expanded -> {
            FitnessAppLandscape()
        }
    }

}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FitnessAppPotrait(){
    Scaffold (bottomBar = {
        BottomNavigation()
    }){
HomeSections()
    }
}
@Preview(widthDp = 360, heightDp = 640)
@Composable
fun FitnessAppPreview(){
FitnessAppPotrait()

}

@Composable
fun FavoriteCollectionsGridPreview(){
    FavoriteCollectionsGrid(gridList = listOf(
        FavoriteCollectionGrid(images = R.drawable.fc1_short_mantras, text = R.string.fc1_short_mantras),
        FavoriteCollectionGrid(images = R.drawable.fc3_stress_and_anxiety, text = R.string.fc3_stress_and_anxiety),
        FavoriteCollectionGrid(images = R.drawable.fc5_overwhelmed, text = R.string.fc5_overwhelmed),
        FavoriteCollectionGrid(images = R.drawable.fc2_nature_meditations, text = R.string.fc2_nature_meditations),
        FavoriteCollectionGrid(images = R.drawable.fc4_self_massage, text = R.string.fc4_self_massage),
        FavoriteCollectionGrid(images = R.drawable.fc6_nightly_wind_down, text = R.string.fc6_nightly_wind_down),

        ))
}
@Preview
@Composable
fun AlignYourBodyRowPreview(){
  AlignYourBodyRow(rowDataList = listOf(

      RowData(images = R.drawable.ab1_inversions, text = R.string.ab1_inversions),
      RowData(images = R.drawable.ab2_quick_yoga, text = R.string.ab2_quick_yoga),
      RowData(images = R.drawable.ab3_stretching, text = R.string.ab3_stretching),
      RowData(images = R.drawable.ab4_tabata, text = R.string.ab4_tabata),
      RowData(images = R.drawable.ab5_hiit, text = R.string.ab5_hiit),
      RowData(images = R.drawable.ab6_pre_natal_yoga, text = R.string.ab6_pre_natal_yoga),


      ))
}


