import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieRecommendationSystemGUI extends JFrame implements ActionListener {
    
    private HashMap<String, ArrayList<String>> movieDatabase;
    private ArrayList<String> favoriteMovies;
    private JComboBox<String> genreComboBox;
    private JTextArea recommendationTextArea;

    public MovieRecommendationSystemGUI() {
        movieDatabase = new HashMap<>();
        movieDatabase.put("Action", new ArrayList<>(List.of("Die Hard", "The Matrix", "Terminator", "Judgement Day", "Mad Max:Fury Road", "John Wick", "Mission:Impossible-Fallout", "The Dark Knight", "The Equlizer", "Taken")));
        movieDatabase.put("Comedy", new ArrayList<>(List.of("Bridesmaids", "The Hangover", "Napoleon Dynamite", "Superbad", "Borat", "Means Girl", "Step Brothers", "Tootsie", "Wedding Crashers", "Ghostbusters")));
        movieDatabase.put("Drama", new ArrayList<>(List.of("The Shawshank Redemption", "The Godfather", "Forrest Gump", "The Departed", "Moonlight", "The Green Mile", "The Hurt Locker", "Dead Poet Society", "The Silence of the Lambs", "Atonement")));
        movieDatabase.put("Science Fiction", new ArrayList<>(List.of("Blade Runner", "The Terminator", "The War of the Worlds", "A Space Odyssey", "Arrival", "Star Wars", "Alien", "The Matrix", "Avatar", "Inception", "Forbidden Planet", "The Fifth Element", "Planet of the Apes", "Edge of Tomorrow", "Jurassic Park", "Contact", "Minority Report", "Metropolis", "Intersteller")));
        movieDatabase.put("Horror", new ArrayList<>(List.of("The Exorcist", "The Shining", "Halloween", "A Nightmare on Elm Street", "Friday the 13th", "The Texas Chainsaw Massacre", "The Silence of the Lambs", "The Conjuring", "Scream", "Psycho", "The Ring", "Get Out", "Hereditary", "It", "The Babadook", "The Blair Witch Project", "The Omen", "Insidious", "Paranormal Activity", "Rosemary's Baby")));
        movieDatabase.put("Romance", new ArrayList<>(List.of("The Notebook", "Titanic", "The Fault in Our Stars", "A Walk to Remember", "Pride and Prejudice", "The Twilight Saga", "Fifty Shades of Grey", "Dirty Dancing", "The Time Traveler's Wife", "Notting Hill", "The Vow", "Me Before You", "The Best of Me", "Dear John", "The Lucky One", "The Last Song", "Safe Haven", "The Longest Ride", "The Choice", "The Fault in Our Stars")));
        movieDatabase.put("Thriller", new ArrayList<>(List.of("Silence of the Lambs", "Se7en", "The Girl with the Dragon Tattoo", "Basic Instinct", "Fatal Attraction", "Cape Fear", "Psycho", "Misery", "The Fugitive", "The Sixth Sense", "Gone Girl", "The Hand That Rocks the Cradle", "The Usual Suspects", "The Shining", "Memento", "Shutter Island", "The Silence", "The Talented Mr. Ripley", "Zodiac", "The Departed")));
        movieDatabase.put("Fantasy", new ArrayList<>(List.of("The Lord of the Rings trilogy", "Harry Potter series", "The Hobbit trilogy", "The Chronicles of Narnia series", "The Wizard of Oz", "The Dark Crystal", "Labyrinth", "Pan's Labyrinth", "Stardust", "Pirates of the Caribbean series", "The NeverEnding Story", "Willow", "Maleficent", "The Princess Bride", "Coraline", "Big Fish", "Edward Scissorhands", "The Golden Compass", "Alice in Wonderland", "Fantastic Beasts and Where to Find Them")));
        movieDatabase.put("Animation", new ArrayList<>(List.of("Toy Story", "The Lion King", "Finding Nemo", "Up", "Inside Out", "Spirited Away", "Shrek", "Frozen", "Zootopia", "The Incredibles", "Wall-E", "Ratatouille", "Beauty and the Beast", "The Nightmare Before Christmas", "Moana", "The Lego Movie", "Coco", "How to Train Your Dragon", "The Iron Giant", "Raya and the Last Dragon")));
        movieDatabase.put("Adventure", new ArrayList<>(List.of("Indiana Jones and the Raiders of the Lost Ark", "The Lord of the Rings: The Fellowship of the Ring", "Jurassic Park", "Pirates of the Caribbean: The Curse of the Black Pearl", "National Treasure", "The Goonies", "Jumanji", "The Secret Life of Walter Mitty", "Up", "The Revenant", "The Martian", "King Kong", "The Chronicles of Narnia: The Lion", "The Witch and the Wardrobe", "The Mummy", "The Adventures of Tintin", "Journey to the Center of the Earth", "Into the Wild", "Life of Pi", "Aquaman")));
        movieDatabase.put("Documentary", new ArrayList<>(List.of("Blackfish", "Amy", "March of the Penguins", "The Cove", "Bowling for Columbine", "The Fog of War", "Fahrenheit 9/11", "An Inconvenient Truth", "Man on Wire", "13th", "Citizenfour", "Jiro Dreams of Sushi", "I Am Not Your Negro", "Faces Places", "Free Solo", "RBG", "Apollo 11", "My Octopus Teacher", "Seaspiracy", "Fyre: The Greatest Party That Never Happened")));
        movieDatabase.put("Historical Fiction", new ArrayList<>(List.of("The Godfather Part II", "Gone with the Wind", "Titanic", "Lawrence of Arabia", "Gladiator", "Braveheart", "Saving Private Ryan", "Schindler's List", "Ben-Hur", "The Last Samurai", "Amadeus", "Troy", "Elizabeth", "The Tudors", "Dances with Wolves", "The Patriot", "The Imitation Game", "Gangs of New York", "The English Patient", "Out of Africa")));
        movieDatabase.put("Mystery", new ArrayList<>(List.of("The Maltese Falcon", "Chinatown", "Rear Window", "Memento", "Se7en", "The Usual Suspects", "The Silence of the Lambs", "Zodiac", "The Girl with the Dragon Tattoo", "Gone Girl", "Murder on the Orient Express", "The Da Vinci Code", "Shutter Island", "The Prestige", "The Sixth Sense", "Knives Out", "The Hateful Eight", "The Secret in Their Eyes", "The Fugitive", "The Others")));
        movieDatabase.put("Crime", new ArrayList<>(List.of("The Godfather", "The Departed", "Goodfellas", "The Silence of the Lambs", "Heat", "Pulp Fiction", "Reservoir Dogs", "The Usual Suspects", "Casino", "American Gangster", "The French Connection", "Scarface", "The Untouchables", "Training Day", "The Town", "The Italian Job", "Catch Me If You Can", "The Equalizer 2", "Inside Man", "The Irishman")));
        movieDatabase.put("War", new ArrayList<>(List.of("Saving Private Ryan", "Schindler's List", "Platoon", "Apocalypse Now", "Full Metal Jacket", "The Deer Hunter", "Dunkirk", "Black Hawk Down", "The Hurt Locker", "Hacksaw Ridge", "Letters from Iwo Jima", "Bridge of Spies", "Fury", "Paths of Glory", "Inglourious Basterds", "The Great Escape", "Enemy at the Gates", "The Thin Red Line", "Zero Dark Thirty", "We Were Soldiers")));
        movieDatabase.put("Western", new ArrayList<>(List.of("The Good", "The Bad and the Ugly", "High Noon", "The Magnificent Seven", "Shane", "Butch Cassidy and the Sundance Kid", "Unforgiven", "True Grit", "Django Unchained", "The Wild Bunch", "Stagecoach", "Tombstone", "The Searchers", "The Outlaw Josey Wales", "Fistful of Dollars", "Once Upon a Time in the West", "The Man Who Shot Liberty Valance", "Rio Bravo", "Open Range", "Silverado", "3:10 to Yuma")));
        movieDatabase.put("Sports", new ArrayList<>(List.of("Rocky", "Raging Bull", "Hoosiers", "Field of Dreams", "Bull Durham", "A League of Their Own", "Rudy", "Space Jam", "Remember the Titans", "Miracle", "Million Dollar Baby", "The Blind Side", "The Fighter", "Moneyball", "The Intouchables", "Creed", "Concussion", "Eddie the Eagle", "I Tonya", "Ford v Ferrari")));
        movieDatabase.put("Musical", new ArrayList<>(List.of("West Side Story", "The Sound of Music", "Singin' in the Rain", "Grease", "La La Land", "Les Misérables", "The Wizard of Oz", "Moulin Rouge", "Beauty and the Beast", "Fiddler on the Roof", "Mary Poppins", "Chicago", "Cabaret", "Dreamgirls", "Mamma Mia", "The Phantom of the Opera", "Hairspray", "Rocky Horror Picture Show", "Into the Woods", "Little Shop of Horrors")));
        movieDatabase.put("Family", new ArrayList<>(List.of("The Lion King", "Finding Nemo", "Toy Story", "Up", "Frozen", "Inside Out", "The Incredibles", "Moana", "Coco", "Beauty and the Beast", "Paddington", "The Sound of Music", "Mary Poppins", "The Parent Trap", "Home Alone", "Hook", "Harry Potter and the Philosopher's Stone", "The Chronicles of Narnia: The Lion", "The Witch and the Wardrobe", "Willy Wonka and the Chocolate Factory", "A Christmas Carol")));
        movieDatabase.put("Biographical", new ArrayList<>(List.of("The Social Network", "A Beautiful Mind", "The Imitation Game", "The Theory of Everything", "The King's Speech", "Hidden Figures", "The Pursuit of Happyness", "The Blind Side", "The Wolf of Wall Street", "The Fighter", "Lincoln", "Schindler's List", "Gandhi", "Malcolm X", "Selma", "Frida", "Ray", "Catch Me If You Can", "Walk the Line", "Bohemian Rhapsody")));
        favoriteMovies = new ArrayList<>();

        setTitle("Movie Recommendation System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel genreLabel = new JLabel("Select your favorite movie genre:");
        genreComboBox = new JComboBox<>(new String[]{"Action", "Comedy", "Drama", "Science Fiction", "Horror", "Romance", "Thriller", "Fantasy", "Animation", "Adventure", "Documentary", "Historical Fiction", "Mystery", "Crime", "War", "Western", "Sports", "Musical", "Family", "Biographical"});
        JButton recommendButton = new JButton("Get Recommendations");
        recommendButton.addActionListener(this);
        recommendationTextArea = new JTextArea(10, 20);
        recommendationTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(recommendationTextArea);
        JButton saveButton = new JButton("Save Favorite");
        saveButton.addActionListener(this);
        JButton favoritesButton = new JButton("My Favorites");
        favoritesButton.addActionListener(this);

        JPanel genrePanel = new JPanel(new GridLayout(2, 1));
        genrePanel.add(genreLabel);
        genrePanel.add(genreComboBox);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(recommendButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(favoritesButton);

        add(genrePanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        MovieRecommendationSystemGUI gui = new MovieRecommendationSystemGUI();
        gui.setVisible(true);
    }
   
    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Get Recommendations")) {
        String selectedGenre = (String) genreComboBox.getSelectedItem();
        ArrayList<String> movies = movieDatabase.get(selectedGenre);
        if (movies == null || movies.size() == 0) {
            recommendationTextArea.setText("No movies found in this genre.");
        } else {
            StringBuilder recommendations = new StringBuilder();
            recommendations.append("Recommended movies:\n");
            for (String movie : movies) {
                recommendations.append("- ").append(movie).append("\n");
            }
            recommendationTextArea.setText(recommendations.toString());
        }
    } else if (e.getActionCommand().equals("Save Favorite")) {
        String selectedMovie = recommendationTextArea.getSelectedText();
        if (selectedMovie == null) {
            recommendationTextArea.setText("Please select a movie recommendation to save.");
        } else {
            favoriteMovies.add(selectedMovie);
            recommendationTextArea.setText("Added " + selectedMovie + " to favorites.");
        }
    } else if (e.getActionCommand().equals("My Favorites")) {
        if (favoriteMovies.size() == 0) {
            recommendationTextArea.setText("You have not saved any favorites yet.");
        } else {
            StringBuilder favorites = new StringBuilder();
            favorites.append("Your favorite movies:\n");
            for (String movie : favoriteMovies) {
                favorites.append("- ").append(movie).append("\n");
            }
            recommendationTextArea.setText(favorites.toString());
        }
    }
}
}


