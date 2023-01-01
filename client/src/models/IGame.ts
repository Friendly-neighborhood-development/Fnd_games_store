interface IGenre {
    id: string,
    name: string
}

interface IDeveloper {
    id: string,
    name: string
}

interface IPlatform {
    id: string
    name: string
}

interface IFeature {
    id: string,
    name: string
}

interface IPublisher {
    id: string,
    name: string
}

export interface IGame {
    id: number
    name: string
    base64Image: string
    description: string
    developer: IDeveloper
    discount: number
    features: Array<IFeature>
    genre: Array<IGenre>
    platform: Array<IPlatform>
    price: number
    publisher: IPublisher
    releaseDate: string
}