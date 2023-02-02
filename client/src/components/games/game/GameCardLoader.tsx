import React, {FC} from 'react';

export const GameCardLoader: FC = () => {
    return (
            <div
                role={"status"}
                className={"flex flex-wrap pb-4 bg-white justify-between lg:shadow-md rounded-lg lg:overflow-hidden lg:before:block lg:before:absolute lg:before:-inset-1 lg:hover:before:bg-gray-400/10 dark:lg:hover:before:bg-gray-200/10 lg:relative lg:inline-block dark:bg-slate-800/50 animate-pulse"}>
                <div
                    className={"h-72 md:h-56 w-60 lg:w-full overflow-hidden flex justify-center items-center mb-4 rounded-sm"}>
                    <div className={"w-full h-full bg-gray-300 dark:bg-gray-500"}></div>
                </div>
                <div className={"w-full px-2"}>
                    <div
                        className={"h-10 text-ellipsis whitespace-nowrap overflow-hidden dark:text-gray-200"}>
                        <div className={"rounded-xl w-32 h-5 bg-gray-300 dark:bg-gray-500"}></div>
                    </div>
                    <div className={"flex justify-between"}>
                        <div className={"rounded-xl w-12 h-5 bg-gray-300 dark:bg-gray-500"}></div>
                        <div className={"rounded-xl w-20 h-5 bg-gray-300 dark:bg-gray-500"}></div>
                    </div>
                </div>
            </div>
    )
}
