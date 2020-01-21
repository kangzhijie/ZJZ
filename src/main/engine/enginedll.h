#pragma once

#if defined(_WIN32) || defined(_WIN64)
#define DLLEXPORT __declspec(dllexport)
#define DLLIMPORT __declspec(dllimport)
#else
#define DLLEXPORT __attribute__((__visibility__("default")))
#define DLLIMPORT
#endif

#if defined(BUILD_DLL)
#define DLL_EXPORT DLLEXPORT
#else
#define DLL_EXPORT DLLIMPORT
#endif

#include <stdint.h>

#define MAX_NUM_MOVES 256

#ifdef __cplusplus
extern "C" {
#endif

	struct egSettings
	{
		uint64_t num_nodes;
		int vc3_max_depth;
		int vc2_max_times;
		int num_max_attack_moves;
		int num_max_defend_moves;
		double attack_move_score_threash_hold;
		double defend_move_score_threash_hold;
	};

	struct egMoves
	{
		int num;
		int arr[MAX_NUM_MOVES];
	};

	struct egExtMove
	{
		int move;
		double score;
	};

	struct egExtMoves
	{
		int num;
		egExtMove arr[MAX_NUM_MOVES];
	};
	// call this once at the beginning of use other functions.
	DLL_EXPORT void Init();

	
	DLL_EXPORT void CollectMoves(const egMoves& input, egExtMoves& output);	
	DLL_EXPORT void Scan(const egMoves& input, const char* input_file, const char* output_file);
	
	
#ifdef __cplusplus
}
#endif

