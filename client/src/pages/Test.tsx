import React, {memo, useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchGames} from "../store/actions/gameAction";
import GamesCategory from "../components/GamesCategory";

const Test = memo(() => {
    const {games, isLoading, error} = useAppSelector(state => state.game)
    const dispatch = useAppDispatch()

    useEffect(() => {
        dispatch(fetchGames())
    }, [])
    return (
        <MainLayout>
            <div className={"flex flex-col"}>
                <GamesCategory games={games} title={"Test"}/>
                {isLoading && <h1>Идёт загрузка..</h1>}
                {error && <h1>{error}</h1>}
            </div>
        </MainLayout>
    );
});

export default Test;