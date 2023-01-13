package com.dian.amuseme.DiscoverJokes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;

import com.dian.amuseme.DiscoverJokes.DadJokesApi.DadJokesRepository;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.JokeDTO;
import com.dian.amuseme.DiscoverJokes.DadJokesApi.OnGetRandomJokeCallback;
import com.dian.amuseme.R;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackListener;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.StackFrom;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;
import java.util.List;


public class DiscoverJokesFragment extends Fragment {
    private static final String TAG = "DiscoverJokesFragment";
    private ImageButton imageButtonDiscardJoke, imageButtonSaveJokeToFavorites;
    private TextView textViewJoke;
    private DadJokesRepository repository;

    private CardStackLayoutManager manager;
    private CardStackAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover_jokes, container, false);
        repository = DadJokesRepository.getInstance();

        setupViews(view);
        connectComponents();

        return view;
    }

    private void connectComponents() {
        /*
        imageButtonDiscardJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                repository.getRandomJoke(new OnGetRandomJokeCallback() {
                    @Override
                    public void onSuccess(List<JokeDTO> list) {
                        //textViewJoke.setText(list.get(0).toString());
                    }

                    @Override
                    public void onError() {
                        textViewJoke.setText("Out of jokes...");
                    }
                });
                Toast.makeText(view.getContext(), "Joke Discarded", Toast.LENGTH_SHORT).show();
            }
        });
        imageButtonSaveJokeToFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Joke Added To Favorites", Toast.LENGTH_SHORT).show();
            }
        });

         */
    }

    private void setupViews(View view) {
        //imageButtonDiscardJoke = view.findViewById(R.id.imageButtonDiscardJoke);
        //imageButtonSaveJokeToFavorites = view.findViewById(R.id.imageButtonSaveJokeToFavorites);
        //textViewJoke = view.findViewById(R.id.textViewJoke);
        setupCardStackView(view);
    }

    private void setupCardStackView(View view) {
        CardStackView cardStackView = view.findViewById(R.id.cardStackView);
        manager = new CardStackLayoutManager(view.getContext(), new CardStackListener() {
            @Override
            public void onCardDragging(Direction direction, float ratio) {
                /*Log.d(TAG, "onCardDraggin=" + direction.name() + " ratio=" + ratio);
                 */
            }

            @Override
            public void onCardSwiped(Direction direction) {
                /*
                Log.d(TAG, "onCardSwiped=" + direction.name());
                if(direction == Direction.Right) {
                    Toast.makeText(view.getContext(), "Direction right", Toast.LENGTH_SHORT);
                }
                else if(direction == Direction.Left) {
                    Toast.makeText(view.getContext(), "Direction left", Toast.LENGTH_SHORT);

                }
                else if(direction == Direction.Bottom) {
                    Toast.makeText(view.getContext(), "Direction bottom", Toast.LENGTH_SHORT);

                }
                else if(direction == Direction.Top) {
                    Toast.makeText(view.getContext(), "Direction top", Toast.LENGTH_SHORT);
                }

                if(manager.getTopPosition() == adapter.getItemCount() - 2) {
                    paginate();
                }

                 */
                if(direction == Direction.Right) {
                    //TODO add the joke to favorites repository
                    Toast.makeText(view.getContext(), adapter.getItems().get(manager.getTopPosition()-1).getSetup(), Toast.LENGTH_SHORT).show();
                }

                //Log.d(TAG, manager.getTopPosition() + " vs " + adapter.getItemCount());
                if(manager.getTopPosition() == adapter.getItemCount() - 2) {
                    //Toast.makeText(view.getContext(), "try to paginate", Toast.LENGTH_SHORT).show();
                    repository.getRandomJokes(new OnGetRandomJokeCallback() {
                        @Override
                        public void onSuccess(List<JokeDTO> list) {
                            List<JokeDTO> oldItems = adapter.getItems();
                            oldItems.addAll(list);
                            adapter.notifyItemRangeChanged(oldItems.size(), list.size());
                        }

                        @Override
                        public void onError() {

                        }
                    });

                }
            }

            @Override
            public void onCardRewound() {
                //Log.d(TAG, "onCardRewound= p=" + manager.getTopPosition());

            }

            @Override
            public void onCardCanceled() {
                //Log.d(TAG, "onCardCanceled=" + manager.getTopPosition());

            }

            @Override
            public void onCardAppeared(View view, int position) {
                /*TextView textView = view.findViewById(R.id.textViewJokeSetup);
                Log.d(TAG, "onCardAppeared: " + position + ", setup: " + textView.getText());

                 */
            }

            @Override
            public void onCardDisappeared(View view, int position) {
                /*
                TextView textView = view.findViewById(R.id.textViewJokeSetup);
                Log.d(TAG, "onCardDisappeared: " + position + ", setup: " + textView.getText());

                 */
            }
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


    /*
    private void paginate() {
        List<ItemModel> oldItems = adapter.getItems();
        List<ItemModel> newItems = addList();
        oldItems.addAll(newItems);
        adapter.notifyItemRangeChanged(oldItems.size(), newItems.size());

        List<ItemModel> newItems = new ArrayList<>(addList());

        //CardStackCallback callback = new CardStackCallback(oldItems, newItems);

        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        adapter.setItems(newItems);

        //result.dispatchUpdatesTo(adapter);

    }
*/
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