import React, {useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useNavigate, useParams} from "react-router-dom";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchOneGame} from "../store/actions/gameAction";
import {GamePrice} from "../components/games/game/GamePrice";
import Button from "../components/UI/Button";

const GameName = () => {
    const {name} = useParams()
    const navigate = useNavigate()

    const dispatch = useAppDispatch()
    const {game, loading, error} = useAppSelector((state) => state.game)
    useEffect(() => {
        if (!name) navigate("/error")
        else dispatch(fetchOneGame(name))
    }, [])

    if (loading === "failed") {
        navigate("/error")
    }

    return (
        <MainLayout>
            <h1 className={"text-3xl"}>{game.name}</h1>
            <div className={"flex"}>
                <div className={"w-3/4 pr-20"}>
                    <img src={game?.base64Image}/>
                    <div>{game?.description}</div>
                </div>
                <div className={"w-1/4 space-y-4 "}>

                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>genre</div>
                        <div>{game?.genre?.map((g) => (
                            <> {g.name}</>
                        ))}</div>
                    </div>
                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>developer</div>
                        <div>{game?.developer?.name}</div>
                    </div>
                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>publisher</div>
                        <div>{game?.publisher?.name}</div>
                    </div>
                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>features</div>
                        <div>{game?.features?.map((feature) => (
                            <> {feature.name}</>
                        ))}</div>
                    </div>
                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>platform</div>
                        <div>{game?.platform?.map((pl) => (
                            <> {pl.name}</>
                        ))}</div>
                    </div>
                    <div className={"flex justify-between border-b border-b-slate-800 py-1"}>
                        <div>release date</div>
                        <div>{game?.releaseDate}</div>
                    </div>
                    <GamePrice price={game?.price} discount={game?.discount}/>
                    <Button
                        className={"capitalize text-white bg-blue-600 w-full dark:bg-sky-500 dark:text-slate-800"}>
                        add to cart
                    </Button>

                </div>
            </div>
        </MainLayout>
    );
};

export default GameName;