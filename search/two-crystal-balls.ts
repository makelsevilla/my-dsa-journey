export default function two_crystal_balls(breaks: boolean[]): number {

    const jmpLength = Math.floor(Math.sqrt(breaks.length))

    let index = jmpLength;

    while (index < breaks.length) {
        if (breaks[index]) {
            break;
        }
        index += jmpLength
    }
    

    index -= jmpLength - 1

    for (let i = 0; i < (jmpLength - 1) && index < breaks.length; ++i) {
        if (breaks[index + i]) {
            return index + i
        }
    }

    return -1
}
