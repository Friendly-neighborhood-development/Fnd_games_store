import React, {FC} from 'react';
import CustomInput from "./CustomInput";

interface SearchProps {
    placeholder: string
}

const Search: FC<SearchProps> = ({placeholder}) => {
    return (
        <div className={"rounded-2xl bg-white mb-2 w-80 p-4 flex"}>
            <span className={"mr-4 flex justify-center"}>
                <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6"
                     fill="none" viewBox="0 0 24 24" stroke="currentColor"
                     strokeWidth={2}>
                    <path strokeLinecap="round" strokeLinejoin="round" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
                </svg>
            </span>
            <CustomInput type={"text"} placeholder={placeholder}/>
        </div>
    );
};

export default Search;