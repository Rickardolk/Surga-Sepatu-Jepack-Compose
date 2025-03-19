package com.example.surgasepatu.view.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surgasepatu.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    modifier: Modifier = Modifier
) {
    var searchQuery by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    val items = listOf("Porte", "Air Jordan", "Air Max", "Air Force", "Compos", "Nike", "Adidas","Vans", "Converse")
    val filterItems = items.filter { it.contains(searchQuery, ignoreCase = true) }

    Column(
        modifier
            .fillMaxWidth()
    ) {
        SearchBar(
            query = searchQuery,
            onQueryChange = {searchQuery = it},
            onSearch = {active = false},
            active = active,
            onActiveChange = {active = it},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = "Search")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "ic search",
                    tint = colorResource(id = R.color.onyx_black)
                )
            },
            colors = SearchBarDefaults.colors(
                containerColor = colorResource(id = R.color.bright_gray)
            )
        ) {
            if (searchQuery.isNotEmpty()) {
                if (filterItems.isNotEmpty()) {
                    LazyColumn {
                        items(filterItems.size) { index ->
                            Text(
                                text = filterItems[index],
                                modifier.padding(16.dp)
                            )
                        }
                    }
                } else {
                    Text(
                        text = "Not found",
                        modifier.padding(16.dp)
                    )
                }
            } else {
                Text(
                    text = "Type to search",
                    modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun view() {
    Search()
}