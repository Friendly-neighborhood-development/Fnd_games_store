import React, {useEffect} from 'react';
import MainLayout from "../components/layouts/MainLayout";
import {useNavigate, useParams} from "react-router-dom";
import {useAppDispatch, useAppSelector} from "../hooks/redux";
import {fetchOneGame} from "../store/actions/gameAction";
import {GamePrice} from "../components/games/game/GamePrice";
import Button from "../components/UI/Button";
import {GameSpecificationRow} from "../components/games/game/GameSpecificationRow";

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
            <div className={"flex flex-col lg:flex-row"}>
                <div className={"lg:w-2/3 lg:pr-10"}>
                    <div className={"mb-3 min-w-full h-96 overflow-hidden bg-gradient-to-b from-sky-400/20 to-blue-700/20 flex justify-center rounded-lg"}>
                        <img className={"lg:rounded-lg lg:w-72"} src={game?.base64Image}/>
                    </div>
                    <div className={"hidden lg:block"}>{game?.description}</div>
                </div>
                <div className={"lg:w-1/3"}>
                    <div className={"flex flex-col-reverse lg:flex-col space-y-4"}>
                        <div className={"space-y-4 mt-4 lg:mt-0"}>
                            <GameSpecificationRow title={"genre"} arrayValue={game.genre}/>
                            <GameSpecificationRow title={"developer"} value={game.developer?.name}/>
                            <GameSpecificationRow title={"publisher"} value={game.publisher?.name}/>
                            <GameSpecificationRow title={"features"} arrayValue={game.features}/>
                            <GameSpecificationRow title={"platform"} arrayValue={game.platform}/>
                            <GameSpecificationRow title={"release date"} value={game.releaseDate}/>
                        </div>
                        <div className={"space-y-4"}>
                            <GamePrice price={game?.price} discount={game?.discount}/>
                            <Button
                                className={"capitalize text-white bg-blue-600 w-full dark:bg-sky-500 dark:text-slate-800"}>
                                add to cart
                            </Button>
                        </div>
                    </div>
                </div>
            </div>
        </MainLayout>
    );
};

export default GameName;