package com.dian.amuseme.YourJokes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dian.amuseme.R;

import java.util.Arrays;
import java.util.List;

public class YourJokesFragment extends Fragment {
    private RecyclerView recyclerViewYourJokes;
    private List<OwnJoke> jokeList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_your_jokes, container, false);
        recyclerViewYourJokes = view.findViewById(R.id.recyclerViewYourJokes);
        jokeList = Arrays.asList(
                new OwnJoke("Watch this!", "Virtual reality (VR) is a simulated experience that employs pose tracking and 3D near-eye displays to give the user an immersive feel of a virtual world."),
                new OwnJoke("Where you going?", "Currently, standard virtual reality systems use either virtual reality headsets or multi-projected environments to generate some realistic images, sounds and other sensations that simulate a user's physical presence in a virtual environment."),
                new OwnJoke("This is the answer!", "A person using virtual reality equipment is able to look around the artificial world, move around in it, and interact with virtual features or items. The effect is commonly created by VR headsets consisting of a head-mounted display with a small screen in front of the eyes, but can also be created through specially designed rooms with multiple large screens. Virtual reality typically incorporates auditory and video feedback, but may also allow other types of sensory and force feedback through haptic technology."),
                new OwnJoke("OMG BRO?!", "\"Virtual\" has had the meaning of \"being something in essence or effect, though not actually or in fact\" since the mid-1400s."),
                new OwnJoke("Where you going?", "Currently, standard virtual reality systems use either virtual reality headsets or multi-projected environments to generate some realistic images, sounds and other sensations that simulate a user's physical presence in a virtual environment."),
                new OwnJoke("OMG BRO?!", "\"Virtual\" has had the meaning of \"being something in essence or effect, though not actually or in fact\" since the mid-1400s."),
                new OwnJoke("This is the answer!", "A person using virtual reality equipment is able to look around the artificial world, move around in it, and interact with virtual features or items. The effect is commonly created by VR headsets consisting of a head-mounted display with a small screen in front of the eyes, but can also be created through specially designed rooms with multiple large screens. Virtual reality typically incorporates auditory and video feedback, but may also allow other types of sensory and force feedback through haptic technology."),
                new OwnJoke("Watch this!", "Virtual reality (VR) is a simulated experience that employs pose tracking and 3D near-eye displays to give the user an immersive feel of a virtual world."),
                new OwnJoke("OMG BRO?!", "\"Virtual\" has had the meaning of \"being something in essence or effect, though not actually or in fact\" since the mid-1400s."),
                new OwnJoke("This is the answer!", "A person using virtual reality equipment is able to look around the artificial world, move around in it, and interact with virtual features or items. The effect is commonly created by VR headsets consisting of a head-mounted display with a small screen in front of the eyes, but can also be created through specially designed rooms with multiple large screens. Virtual reality typically incorporates auditory and video feedback, but may also allow other types of sensory and force feedback through haptic technology."),
                new OwnJoke("Watch this!", "Virtual reality (VR) is a simulated experience that employs pose tracking and 3D near-eye displays to give the user an immersive feel of a virtual world."),
                new OwnJoke("Watch this!", "Virtual reality (VR) is a simulated experience that employs pose tracking and 3D near-eye displays to give the user an immersive feel of a virtual world."),
                new OwnJoke("Where you going?", "Currently, standard virtual reality systems use either virtual reality headsets or multi-projected environments to generate some realistic images, sounds and other sensations that simulate a user's physical presence in a virtual environment."),
                new OwnJoke("This is the answer!", "A person using virtual reality equipment is able to look around the artificial world, move around in it, and interact with virtual features or items. The effect is commonly created by VR headsets consisting of a head-mounted display with a small screen in front of the eyes, but can also be created through specially designed rooms with multiple large screens. Virtual reality typically incorporates auditory and video feedback, but may also allow other types of sensory and force feedback through haptic technology."),
                new OwnJoke("OMG BRO?!", "\"Virtual\" has had the meaning of \"being something in essence or effect, though not actually or in fact\" since the mid-1400s."),
                new OwnJoke("Where you going?", "Currently, standard virtual reality systems use either virtual reality headsets or multi-projected environments to generate some realistic images, sounds and other sensations that simulate a user's physical presence in a virtual environment.")
                );
        recyclerViewYourJokes.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));
        recyclerViewYourJokes.setAdapter(new OwnJokesAdapter(jokeList));

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        reloadJokeList();
    }

    private void reloadJokeList() {
        //TODO IMPLEMENT THIS
    }
}