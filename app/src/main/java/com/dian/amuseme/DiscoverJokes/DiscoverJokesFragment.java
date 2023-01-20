package com.dian.amuseme.DiscoverJokes;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.DadJokesRepository;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.OnGetRandomJokeCallback;
import com.dian.amuseme.LocalDatabase.FavoriteJokeViewModel;
import com.dian.amuseme.LocalDatabase.FavoriteJokesRepository;
import com.dian.amuseme.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;


public class DiscoverJokesFragment extends Fragment {
    private static final String TAG = "DiscoverJokesFragment";
    private DadJokesRepository repository;

    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;

    private FavoriteJokeViewModel jokeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_jokes, container, false);
        repository = DadJokesRepository.getInstance();
        jokeViewModel = new ViewModelProvider(this).get(FavoriteJokeViewModel.class);
        jokeViewModel.getFavoriteJokes().observe(getViewLifecycleOwner(), jokes -> Log.d(TAG, jokes.toString()));

        setupViews(view);

        return view;
    }

    private void setupViews(View view) {
        setupCardStackView(view);
    }

    private void setupCardStackView(View view) {
        CardStackView cardStackView = view.findViewById(R.id.cardStackView);
        manager = new CardStackLayoutManager(view.getContext(), new CardStackListener() {
            @Override
            public void onCardSwiped(Direction direction) {
                if(direction == Direction.Right) {
                    JokeDTO jokeDTO = adapter.getItems().get(manager.getTopPosition()-1);
                    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
                    jokeDTO.setTimeAdded(formatter.format(LocalDateTime.now()));
                    jokeViewModel.insert(jokeDTO);
                }

                if(manager.getTopPosition() == adapter.getItemCount() - 2) {
                    repository.getRandomJokes(new OnGetRandomJokeCallback() {
                        @Override
                        public void onSuccess(List<JokeDTO> list) {
                            List<JokeDTO> oldItems = adapter.getItems();
                            oldItems.addAll(list);
                            adapter.notifyItemRangeChanged(oldItems.size(), list.size());
                        }

                        @Override
                        public void onError() {}
                    });
                }
            }
            @Override
            public void onCardDragging(Direction direction, float ratio) {}
            @Override
            public void onCardRewound() {}
            @Override
            public void onCardCanceled() {}
            @Override
            public void onCardAppeared(View view, int position) {}
            @Override
            public void onCardDisappeared(View view, int position) {}
        });

        manager.setStackFrom(StackFrom.None);
        manager.setVisibleCount(3);
        manager.setTranslationInterval(8.0f);
        manager.setScaleInterval(0.95f);
        manager.setSwipeThreshold(0.3f);
        manager.setMaxDegree(20.0f);
        manager.setDirections(Direction.HORIZONTAL);
        manager.setCanScrollHorizontal(true);
        manager.setCanScrollVertical(false);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        manager.setOverlayInterpolator(new LinearInterpolator());
//TODO uncomment this and comment next line when project is done
//
//        adapter = new CardStackAdapter(new ArrayList<>());
//        repository.getRandomJokes(new OnGetRandomJokeCallback() {
//            @Override
//            public void onSuccess(List<JokeDTO> list) {
//                Log.d(TAG, "onsucc=");
//                List<ItemModel> oldItems = adapter.getItems();
//
//                oldItems.addAll(list);
//                adapter.notifyItemRangeChanged(oldItems.size(), list.size());
//            }
//
//            @Override
//            public void onError() {
//                Log.d(TAG, "onerr=");
//            }
//        });
        adapter = new CardStackAdapter(addList());

        cardStackView.setLayoutManager(manager);
        cardStackView.setAdapter(adapter);
        cardStackView.setItemAnimator(new DefaultItemAnimator());
    }

    private List<JokeDTO> addList() {
        List<JokeDTO> items = new ArrayList<>();
        items.add(new JokeDTO("hey", "hahapunchline", "andrei bejan"));
        items.add(new JokeDTO("hey1", "hahapunchline", "andrei bejan"));
        items.add(new JokeDTO("hey2", "hahapunchline", "andrei bejan"));
        items.add(new JokeDTO("hey3", "hahapunchline", "andrei bejan"));
        items.add(new JokeDTO("hey4", "hahapunchline", "andrei bejan"));

        return items;
    }
}