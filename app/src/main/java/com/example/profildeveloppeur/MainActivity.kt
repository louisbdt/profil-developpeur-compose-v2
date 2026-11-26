package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileAvatar(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Photo de profil",
            modifier = Modifier.size(96.dp)
        )
        Surface(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(4.dp),
            shape = MaterialTheme.shapes.small,
            tonalElevation = 4.dp
        ) {
            Text(
                text = "Disponible",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    location: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = role)
        Spacer(modifier = Modifier.height(4.dp))
        Row {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Localisation"
            )
            Text(
                text = location,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
    }
}

@Composable
fun SkillItem(
    skillName: String,
    modifier: Modifier = Modifier
) {
    Text(text = skillName, modifier = modifier)
}

@Composable
fun ContactButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = label)
    }
}

@Composable
fun ProfileCard(
    name: String,
    role: String,
    location: String,
    description: String,
    skills: List<String>,
    contact: String,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ProfileAvatar(
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ProfileHeader(
                name = name,
                role = role,
                location = location,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            for (skill in skills) {
                SkillItem(
                    skillName = skill,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }

            Text(text = contact, modifier = Modifier.padding(bottom = 8.dp))

            ContactButton(
                label = "Voir mon GitHub",
                onClick = onContactClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    ProfileCard(
        name = "Louis Baudat",
        role = "Étudiant en développement web l'ESGI",
        location = "Reims, France",
        description = "Étudiant en développement web à l'ESGI. Je m'intéresse particulièrement au développement full-stack, de Symfony/PHP/C# côté backend à React/TypeScript/Angular côté frontend.",
        skills = listOf("Symfony", "React", "TypeScript", "C#","Angular"),
        contact = "github.com/louisbdt",
        onContactClick = {

        },
        modifier = modifier
            .fillMaxWidth()
            .padding(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileCardJuniorPreview() {
    ProfilDeveloppeurTheme {
        ProfileCard(
            name = "Louis Baudat",
            role = "Étudiant en développement web à l'ESGI",
            location = "Reims, France",
            description = "Je découvre actuellement Android et Jetpack Compose.",
            skills = listOf("Symfony", "React", "TypeScript"),
            contact = "github.com/louisbdt",
            onContactClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileCardFullStackPreview() {
    ProfilDeveloppeurTheme {
        ProfileCard(
            name = "Louis Baudat",
            role = "Développeur full-stack",
            location = "Reims, France",
            description = "En alternance depuis 1 an, où je réalise des applications en C#/Angular",
            skills = listOf("C#", "Angular"),
            contact = "github.com/louisbdt",
            onContactClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}